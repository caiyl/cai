package cai.suanfa;

/**
 * Created by caiyl on 2017/11/7.
 *
 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 3.针对所有的元素重复以上的步骤，除了最后一个。
 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort extends TempSort {

    private Integer[] arr = {9,2,1,7,3,8,5,4,6};

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleSort.arr);
        bubbleSort.show(bubbleSort.arr);
    }

    @Override
    protected void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                //每次循环，最大的元素都会沉到数组最后
                if (isLess(arr[j+1],arr[j])) {//两两比较交换
                    exch(arr,j+1,j);
                }
            }
        }

    }
}
