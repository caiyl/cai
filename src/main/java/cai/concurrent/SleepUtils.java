package cai.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by caiyl on 17/2/22.
 */
public class SleepUtils {
    public static void second(long i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
