package cai.concurrent;

/**
 * volatile线程的可见性、与指令的重排序两个功能
 * 如果没有volatile，线程里的flag不会主动读取主内存的flag
 * cpu屏障，synchonize不能阻止指令重排序
 */
public class ThreadVisibility {
    private static /*volatile*/  boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while ((flag)){
                //do sth
            }
            System.out.println("end");
        },"server").start();;

        Thread.sleep(1000);
        flag = false;
    }
}
