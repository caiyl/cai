package cai.suanfa;

/**
 * Created by caiyl on 2017/12/5.
 */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] arr = {9,2,1,5,7,0,8,3,4,6};

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1]=key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
