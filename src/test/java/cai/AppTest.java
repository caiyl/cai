package cai;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.concurrent.CountDownLatch;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    public void testTime(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 4000000; i++) {
            System.currentTimeMillis();
        }
        long ent = System.currentTimeMillis();
        System.out.println(ent -start);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    private static long result1=0;
    private static long result2=0;
    private static long result3=0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cd = new CountDownLatch(3);
        int n, i;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 101; i++) {
                    result1+=i;
                }
                cd.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 101; i++) {
                    result2+=i;
                }
                cd.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 101; i++) {
                    result3+=i;
                }
                cd.countDown();
            }
        }).start();

        cd.await();
        System.out.println(result1 + result2 + result3 );
        System.out.println("over");
    }
}
