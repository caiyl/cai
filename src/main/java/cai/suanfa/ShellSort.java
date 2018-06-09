package cai.suanfa;

/**
 * Created by caiyl on 2018/4/10.
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        //希尔排序
        int h = a.length;

        while (true) {
            h = h / 3;
            for (int x = 0; x < h; x++) {
                for (int i = x + h; i < a.length; i = i + h) {
                    int temp = a[i];
                    int j;
                    for (j = i - h; j >= 0 && a[j] > temp; j = j - h) {
                        a[j + h] = a[j];
                    }
                    a[j + h] = temp;
                }
            }
            if (h == 1) {
                break;
            }
        }


        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
