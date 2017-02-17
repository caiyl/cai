package cai.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caiyl on 2017/2/17.
 */
public class ThreadEscape {
    private static final Set<String> set = new HashSet<String>();
    public ThreadEscape() {
    }

    protected String getName(){
        return "123";
    }
    public static void main(String[] args) {
        ThreadEscape t =         new ThreadEscape();
        t.set.add("aaa");
    }

    private static ThreadLocal<String> st = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "";
        }
    };

    ThreadEscape t33 = new ThreadEscape(){
        @Override
        protected String getName() {
            return super.getName();
        }
    };
}
