package cai.suanfa;

import junit.framework.TestCase;

/**
 * Created by caiyl on 2017/1/25.
 */
public class InsertSortTest extends TestCase{

    private int[] a = {3,1,6,8,9,6,7,2,0,4,5};

    public void testSort(){
        int[] b = InsertSort.sort2(a);
        for (int i = 0; i < b.length-1; i++) {
            assertTrue(b[i+1] <= b[i]);
        }
    }
}
