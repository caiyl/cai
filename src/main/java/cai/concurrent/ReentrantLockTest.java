package cai.concurrent;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by caiyl on 17/2/22.
 */
public class ReentrantLockTest extends TestCase{

    @Test
    public void testLock(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            System.out.println(111);
        }finally {
            lock.unlock();
        }
    }
}
