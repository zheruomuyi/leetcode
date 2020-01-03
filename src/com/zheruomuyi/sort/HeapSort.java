package com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: HeapSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
        }
        heapSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    private static void heapSort(int[] list) {
        for (int i = list.length-1; i > 0; i--) {
            buildMaxHeap(list,i);
            int x = list[i];
            list[i] = list[0];
            list[0] = x;
        }
    }

    private static void buildMaxHeap(int[] list, int length) {
        for (int j = (length-2)/2; j >= 0; j--) {
            adjustDownToUp(list,length,j);
        }
    }

    private static void adjustDownToUp(int[] list, int length, int i) {
        int n = list[i];
        for(int k = 2*i+1; k<length; k = 2*k+1) {
            if(k+1 < length && list[k+1] > list[k]){
               k++;
            }
            if(list[k] > n) {
                list[i] = list[k];
                i = k;
            }
        }
        list[i] = n;
    }
}
