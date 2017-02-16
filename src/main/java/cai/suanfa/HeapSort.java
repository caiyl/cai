package cai.suanfa;

/**
 * Created by caiyl on 2017/1/26.
 * 堆排序算法
 */
public class HeapSort {

    public static void main(String[] args) {
//        int[] A = {16,4,10,14,7,9,3,2,8,1};
        int[] A = {4,1,3,2,16,9,10,14,8,7};
        HeapSort heapSort = new HeapSort();
        heapSort.maxHeapify(A,1);
        heapSort.buildMaxHeap(A);
        System.out.println(A);
    }


    public void buildMaxHeap(int[] A){
        int heapSize = A.length;
        for (int i = A.length/2; i >0; i--) {
            maxHeapify(A,i);
        }
    }

    public void maxHeapify(int[] A, int i){

        int largest = i;
        int l = left(i);
        int r = right(i);

        if(l <= A.length-1 && A[l] > A[i]){
            largest = l;
        }else{
            largest = i;
        }

        if(r <= A.length-1 && A[r] > A[i]){
            largest = r;
        }

        if(largest != i){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A,largest);
        }

    }

    private int right(int i) {
        return 2*i+1;
    }

    private int left(int i) {
        return 2*i;
    }

}






























































































