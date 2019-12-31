package test.com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: SimpleSelectSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class SimpleSelectSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
        }
        simpleSelectSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    private static void simpleSelectSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int min = Integer.MAX_VALUE;
            int n = i;
            for (int j = i; j < list.length; j++) {
                if(list[j] < min) {
                    min = list[j];
                    n = j;
                }
            }
            list[n] = list[i];
            list[i] = min;
        }
    }
}
