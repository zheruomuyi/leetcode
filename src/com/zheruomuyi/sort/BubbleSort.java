package com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: BubbleSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        bubbleSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    private static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if(list[i] > list[j]){
                    int n = list[i];
                    list[i] = list[j];
                    list[j] = n;
                }
            }
        }
    }
}
