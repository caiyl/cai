package cai.suanfa;

/**
 * Created by caiyl on 2017/11/5.
 * 选择排序
 */
public class SelectSort extends TempSort{

    private Integer[] arr = {9,2,1,7,3,8};

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.sort(selectSort.arr);
        selectSort.show(selectSort.arr);
    }

    @Override
    public void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (isLess(arr[j],arr[min])) {
                    min = j;//找出最新元素的位置,而不是最小值
                }
            }
            exch(arr,i,min);
        }

    }

}
