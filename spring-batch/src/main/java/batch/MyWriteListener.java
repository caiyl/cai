package batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import pojo.BlogInfo;

import java.util.List;

import static java.lang.String.format;

/**
 * @author chase
 * @date 2022/12/1 4:53 PM
 */
public class MyWriteListener implements ItemWriteListener<BlogInfo> {
    private Logger logger = LoggerFactory.getLogger(MyWriteListener.class);

    @Override
    public void beforeWrite(List<? extends BlogInfo> items) {
    }

    @Override
    public void afterWrite(List<? extends BlogInfo> items) {
    }

    @Override
    public void onWriteError(Exception exception, List<? extends BlogInfo> items) {
        try {
            logger.info(format("%s%n", exception.getMessage()));
            for (BlogInfo message : items) {
                logger.info(format("Failed writing BlogInfo : %s", message.toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Bean
    public Step myStep(StepBuilderFactory stepBuilderFactory, ItemReader<BlogInfo> reader,
                       ItemWriter<BlogInfo> writer, ItemProcessor<BlogInfo, BlogInfo> processor){
        return stepBuilderFactory
                .get("myStep")
                .<BlogInfo, BlogInfo>chunk(65000) // Chunk的机制(即每次读取一条数据，再处理一条数据，累积到一定数量后再一次性交给writer进行写入操作)
                .reader(reader).faultTolerant().retryLimit(3).retry(Exception.class).skip(Exception.class).skipLimit(2)
                .listener(new MyReadListener())
                .processor(processor)
                .writer(writer).faultTolerant().skip(Exception.class).skipLimit(2)
                .listener(new MyWriteListener())
                .build();
    }
}