package cai.jdk;

/**
 * Created by caiyl on 2017/2/17.
 */
public class Final {
    private final int a = 0;
    private final int b;

    private static final  int c;
    private static final  int d;

    static {
        c = 0;
//        b = 0;   wrong
        d = 0;
    }

    public Final(){
        b = 0;
//        d = 0; wrond
    }

}
