package cai;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Lock lock = new ReentrantLock();
        System.out.println( "Hello World!" );
    }
}
