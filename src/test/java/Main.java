import junit.framework.TestCase;
import org.fenixsoft.clazz.TestClass;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by caiyl on 2017/3/15.
 */
public class Main extends TestCase{


    @Test
    public void testInsertSort(){
        int[] arr = {9,3,1,5,7,8,6,4,2};

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for(int j = i+1; j < arr.length ;j++){
                if (arr[j] <arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] =  temp;
        }

        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.println(arr[i1]);
        }
    }

}
