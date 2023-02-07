import com.WebApp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author chase
 * @date 2023/1/31 9:03 AM
 * 使用HyperLogLog进行计算计算
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApp.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RedisHyperLogLogTest {

    /** 注入 StringRedisTemplate, 使用默认配置 */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    @SuppressWarnings("all")
    public void testHyperLogLog() {

        HyperLogLogOperations operations = stringRedisTemplate.opsForHyperLogLog();

        // add 方法对应 PFADD 命令
        operations.add("ip_20190301", "192.168.0.1", "192.168.0.2", "192.168.0.3");
        // size 方法对应 PFCOUNT 命令
        System.out.println(operations.size("ip_20190301"));     // 3

        operations.add("ip_20190301", "192.168.0.1", "192.168.0.4");
        System.out.println(operations.size("ip_20190301"));     // 4

        operations.add("ip_20190302", "192.168.0.1", "192.168.0.5");
        System.out.println(operations.size("ip_20190302"));     // 2

        // union 方法对应 PFMERGE 命令
        operations.union("ip_201903", "ip_20190301", "ip_20190302");
        System.out.println(operations.size("ip_201903"));       // 5
        stringRedisTemplate.expire("ip_201903",5, TimeUnit.SECONDS);
        System.out.println("haskey:"+stringRedisTemplate.hasKey("ip_201903"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        operations.add("ip_201903", "192.168.0.1", "192.168.0.5");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("haskey:"+stringRedisTemplate.hasKey("ip_201903"));


    }
}