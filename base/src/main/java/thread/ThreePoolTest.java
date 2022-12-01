package thread;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chase
 * @date 2022/11/25 10:19 AM
 */
public class ThreePoolTest {
    private static ThreadPoolExecutor scheduleExecutor = new ThreadPoolExecutor(10,100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10000),new NamedThreadFactory("ScheduleThread"));

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println("poolSize="+scheduleExecutor.getPoolSize()+",queuesize="+scheduleExecutor.getQueue().size()+",getActiveCount="+scheduleExecutor.getActiveCount());
            scheduleExecutor.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (1 > 2) {
                    System.out.println(123);
                }
            });
        }


    }



}
