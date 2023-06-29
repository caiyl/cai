import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chase
 * @date 2023/1/31 9:03 AM
 * 使用HyperLogLog进行计算计算
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {WebApp.class},
//        webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@Service
public class RedisMapTest {

    /**
     * 注入 StringRedisTemplate, 使用默认配置
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private StringRedisTemplate  stringRedisTemplate;




    @Test
    public void bitMapTest() {
        String allIds = "key17";

        // add 方法对应 PFADD 命令

        // size 方法对应 PFCOUNT 命令
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,10,100, TimeUnit.HOURS,new LinkedBlockingQueue<>());
//        ExecutorService poolExecutor = Executors.newSingleThreadExecutor();

        try {
//            BufferedReader bf = new BufferedReader(new FileReader("/Users/chase/物联网卡/222.csv"));
            BufferedReader bf = new BufferedReader(new FileReader("/Users/chase/物联网卡/cardids.csv"));
            String line = bf.readLine();
            List<Long> list = new ArrayList<>();
            while (line != null) {
                String str = line.replaceAll("\"", "");
                long l = Long.parseLong(str);
                list.add(l);
                line = bf.readLine();
            }
            System.out.println("读取文件完成");

//            new Thread(){
//                @Override
//                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        Long id = list.get(i);
                    poolExecutor.execute(()-> {
                        String k = getPrefixKey(id) + allIds;
                        Long v = MapId(id);
                        redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                            byte[] keyBytes = k.getBytes();
                            connection.multi(); // 开启事务
                            connection.setBit(keyBytes, v, true);
                            connection.expire(keyBytes, 86400);
                            List<Object> results = connection.exec(); // 提交事务
                            return results != null && !results.isEmpty();
                    });
                } );


                    }
//                }
//            }.start();











            System.out.println(bitCount("small"+allIds));
            System.out.println(bitCount("big"+allIds));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPrefixKey(Long id){
        String s = id.toString();
        if (s.length() == 14){
            return "big";
        }else{
            return "small";
        }
    }

//    public static void main(String[] args) {
//        long l  = 41900001422877L;
//        System.out.println(getPrefixKey(l));
//    }
    private static Long MapId(Long id) {
        if (id < 41900000000211L){
            return id;
        }else{
            String s = id.toString();
            s = s.substring(5);
            if ((s.charAt(0) == '0')) {
                s = s.replaceFirst("0", "1");
            }
            return Long.parseLong(s);
        }
    }

    public Long bitCount(String key) {
        long count = (long) redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(key.getBytes()));

        return count;
    }
}