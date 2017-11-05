package cai.suanfa;

/**
 * Created by caiyl on 2017/11/5.
 */
public abstract class  TempSort {

    /**
     * 打印排序过的数据
     * @param arr
     */
    public void show(Comparable [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);

        }
    }

    /**
     * v1是否小于v2
     * @param v1
     * @param v2
     * @return
     */
    public boolean isLess(Comparable v1, Comparable v2){
        return v1.compareTo(v2) < 0;
    }
    /**
     * v1是否大于v2
     * @param v1
     * @param v2
     * @return
     */
    public boolean isGreater(Comparable v1, Comparable v2){
        return v1.compareTo(v2) > 0;
    }

    public void exch(Comparable[] arr,int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    protected  abstract void sort(Comparable[] arr);


/*
    public  boolean isSorted(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (isLess(arr[i],arr[i-1])) {
                return false;
            }
        }
        return true;
    }
*/


}
