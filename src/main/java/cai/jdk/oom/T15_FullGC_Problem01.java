package cai.jdk.oom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** jvm 参数 -Xms50M -Xmx50M -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintFlagsFinal
 * 从数据库中读取信用数据，套用模型，并把结果进行记录和传输
 * 该线程池使用的队列是 new DelayedWorkQueue() ,所以该线程池的队列是无解的，导致任务数不限制，导致的内存溢出
 * 从executor.getQueue().size()观察也可以得知任务队列在不断的增加，导致了内存溢出。
 */

public class T15_FullGC_Problem01 {

    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birthdate = new Date();

        public void m() {}
    }

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) throws Exception {
        executor.setMaximumPoolSize(50);
        executor.scheduleWithFixedDelay(new Task(new CardInfo()), 0, 2, TimeUnit.MILLISECONDS);
        for (;;){
            modelFit();
            Thread.sleep(1000);
//            System.out.println(executor.getQueue().size());
        }
    }

    private static void modelFit(){
        List<CardInfo> taskList = getAllCardInfo();
        int size = taskList.size();
        for (int i = 0; i < 1; i++) {

        }

        taskList.forEach(info -> {
//             do something
            executor.scheduleWithFixedDelay(() -> {
                //do sth with info
                info.m();

            }, 2, 3, TimeUnit.SECONDS);

        });


    }
    private static  AtomicInteger count = new AtomicInteger(0);
    static class Task extends Thread{
        private CardInfo cardInfo;
        public Task(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        @Override
        public void run() {
            cardInfo.m();
        }
    }

    private static List<CardInfo> getAllCardInfo(){
        List<CardInfo> taskList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            CardInfo ci = new CardInfo();
            taskList.add(ci);
        }

        return taskList;
    }
}