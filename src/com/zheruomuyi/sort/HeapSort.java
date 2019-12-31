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
        for (int i = list.length; i > 0; i--) {
            buildMaxHeap(list,i);
            exchange(list, i, 0);
        }
    }

    private static void exchange(int[] list, int i,int j) {
        int x = list[i];
        list[i] = list[j];
        list[j] = x;
    }

    private static void buildMaxHeap(int[] list, int i) {
        for (int j = 0; j < (i-2)/2; j--) {
            adjustDownToUp(list,i,j);
        }
    }

    private static void adjustDownToUp(int[] list, int i, int j) {
        int n = list[i];
        for(int k = 2*j+1; k<i;k = 2*k+1) {
            if(k+1 < i && list[k+1] > list[k]){
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
