package batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import pojo.BlogInfo;

/**
 * @author chase
 * @date 2022/12/1 4:55 PM
 */

public class MyReadListener implements ItemReadListener<BlogInfo> {

    private Logger logger = LoggerFactory.getLogger(MyReadListener.class);

    @Override
    public void beforeRead() {
    }

    @Override
    public void afterRead(BlogInfo item) {
    }

    @Override
    public void onReadError(Exception ex) {
        try {
            logger.info(String.format("%s%n", ex.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}