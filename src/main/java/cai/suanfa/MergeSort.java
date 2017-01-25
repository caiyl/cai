package cai.suanfa;

/**
 * Created by caiyl on 2017/1/25.
 * 归并排序
 */
public class MergeSort {
    private int[] arr = {5,2,4,7,1,3,2,6};

    public void sort(int[]A,int arrBegin, int arrLength){
        if (arrBegin < arrLength ) { //直到分解数组长度为1
            int q = (arrBegin+arrLength)/2;
            sort(A,arrBegin,q);  //递归调用排序
            sort(A,q+1,arrLength);
            merge(A,arrBegin,q,arrLength);//合并两个已经排好序的数组 A[arrbegin,q] 和A[q,arrlength]
        }
    }

    private void merge(int[] A, int left, int midle, int right) {
        int n1 = midle - left + 1;//数组一长度
        int n2 = right - midle;   //数组二长度

        //初始化数组一和数组二
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[left + i -1];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = A[midle+i];
        }

        //哨兵值
        L[L.length-1] = 999999;
        R[R.length-1] = 999999;

        int i = 0;
        int j = 0;

        for (int k=left-1;k < right;k++){ //遍历合并数组
            if(L[i] <= R[j]){
                A[k] = L[i];
                i = i + 1;
            }else{
                A[k] = R[j];
                j = j+1;
            }
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mergeSort.arr,1,mergeSort.arr.length);//从1开始
        System.out.println();
    }
}

















































































