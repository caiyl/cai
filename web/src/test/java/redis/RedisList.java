package redis;

import com.WebApp;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chase
 * @date 2023/2/17 10:47 AM
 */
@SpringBootTest(classes = WebApp.class)
public class RedisList {
    @Setter
    @Autowired
    private RedisTemplate redisTemplate;

    private ListOperations listOperations ;

    private static String key = "list";

    @BeforeEach
    void init(){
        listOperations = redisTemplate.opsForList();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        listOperations.leftPushAll(key,list);
    }

    @Test
    void testSize(){
        System.out.println("size:"+listOperations.size(key));
    }
    @Test
    void testRange(){
        List range = listOperations.range(key, 0, -1);
        System.out.println("rang:"+ range);
        System.out.println(range);
    }

    @Test
    void leftPop(){
        System.out.println(listOperations.size(key));
        Object o = listOperations.leftPop(key, 50, TimeUnit.SECONDS);
        System.out.println("leftPop:"+ o);
        System.out.println(listOperations.size(key));

    }

}
