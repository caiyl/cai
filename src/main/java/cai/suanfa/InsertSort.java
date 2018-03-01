package cai.suanfa;

/**
 * Created by caiyl on 2017/11/5.
 * 插入排序
 *
 1. 从第一个元素开始，该元素可以认为已经被排序
 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 5. 将新元素插入到该位置后
 6. 重复步骤2~5
 */
public class InsertSort extends TempSort{

    private Integer[] arr = {9,2,1,7,3,8,5,4,6};

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.sort(insertSort.arr);
        insertSort.show(insertSort.arr);
    }

    @Override
    public void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {//步骤1
            Comparable insertData = arr[i];//取到数据，相当于取到牌，即将插入的数据

            int j = i-1;//i为多少说明就有多少元素已经排好序

            for (  ; j >= 0 && isLess(insertData,arr[j]); j--) {//步骤2 步骤4
                arr[j+1]=arr[j];//数据往后移动一位  步骤3
            }

            /**
             * 错误，因为j的位置不一定需要减1
             */
//            for (  ; j >= 0 ; j--) {
//                if (isLess(insertData,arr[j])) {
//                    arr[j+1]=arr[j];
//                }
//            }

            arr[j+1] = insertData;//插入值 步骤5
        }

    }

}
