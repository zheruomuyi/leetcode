package com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: MergeSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        mergeSort(list, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    private static void mergeSort(int[] list, int i, int j) {
        if(i < j){
            int mid = (i+j)/2;
            mergeSort(list, i, mid);
            mergeSort(list, mid+1, j);
            merge(list, i, mid, j);
        }
    }

    private static void merge(int[] list, int i, int mid, int j) {
        int[] temp = new int[j-i+1];
        int k=0;
        int left = i,right =mid+1;
        while(left<=mid && right<=j){
            if(list[left] > list[right]){
                temp[k++] = list[right++];
            }else{
                temp[k++] = list[left++];
            }
        }
        while(left<=mid){
            temp[k++] = list[left++];
        }
        while(right<=j){
            temp[k++] = list[right++];
        }
        for (int value : temp) {
            list[i++] = value;
        }

    }
}
