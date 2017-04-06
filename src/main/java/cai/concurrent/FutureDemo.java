package cai.concurrent;

import java.util.concurrent.*;

/**
 * Created by caiyl on 2017/4/5.
 * Future的使用方法
 */
public class FutureDemo {
    /*定义一个线程池*/
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);

    private static class LongTimeTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            /*模拟一个耗时操作*/
            System.out.println("-------begin--------");
            long start = System.currentTimeMillis();
            task();
            long seconds = ((System.currentTimeMillis() - start) / 1000);
            System.out.println("----------任务耗时:"+ seconds + "秒------------" );
            return "1";
        }

        private void task() {
            for (double i = 0; i < 1000000000d; i++) {
            }
        }
    }

    public static void main(String[] args) {

        LongTimeTask task = new LongTimeTask();
        Future<String> future = threadpool.submit(task);

        //主线程等待2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("做其他事情");
        future.cancel(true);

//       获取结果
        try {
            String result = future.get(15,TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("future.get() 阻塞");

        threadpool.shutdown();
    }
}
