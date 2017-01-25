package cai.suanfa;

/**
 * Created by caiyl on 2017/1/25.
 *
 * 算法之插入排序
 */
public class InsertSort {


    public static int[] sort(int[] b){
        for (int i = 1; i < b.length; i++) {
            int key = b[i]; //新要插入的值
            int j = i -1;   // 0 ... i -1

            while (j >= 0 && b[j] >key){  //排好序前面元素从后面往前遍历，当发现元素位置不对时，调换位置，并且j -1
                b[j+1] = b[j];
                j = j-1;
            }

            b[j+1] = key; //新的要插入的位置

        }

        return b;
    }

    public static int[] sort2(int[] b){
        for (int i = 1; i < b.length; i++) {

            int key = b[i];
            int j = i -1;
            while (j >=0 && b[j] < key){
                b[j+1] = b[j];
                j = j -1;
            }
            b[j+1] = key;

        }

        return b;
    }

}
