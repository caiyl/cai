package cai.concurrent;

import java.util.concurrent.Executors;

/**
 * Created by caiyl on 2018/5/20.
 */
public class ThreadPool {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(100);
    }
}
