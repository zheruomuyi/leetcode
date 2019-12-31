package com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: QuickSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
        }
//        doQuickSort(list,0,n-1);
        quickSort(list,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(list[i]+" ");
        }
    }

    private static void quickSort(int[] list, int i, int j) {
        if(i>=j) {
            return;
        }
        int left = i,right = j;
        int temp = list[i];
        while(left < right){
            while(left < right && list[right] >= temp) {
                right--;
            }
            list[left] = list[right];
            while(left < right && list[left] <= temp) {
                left++;
            }
            list[right] = list[left];
        }
        list[left] = temp;
        quickSort(list,i,left-1);
        quickSort(list,left+1, j);
    }

    private static void doQuickSort(int[] list, int i, int j) {
        if(i>=j) {
            return;
        }
        int x=i,y=j;
        int model = findModel(list ,i ,j);
        doQuickSort(list,x,model-1);
        doQuickSort(list,model+1, y);
    }

    private static int findModel(int[] list, int i, int j) {
        int m = list[i];
        int l = i;
        while(i<j){
            while(i<j && list[j] >= m) {
                j--;
            }
            while(i<j && list[i] <= m){
                i++;
            }
            if(i<j){
                int n = list[i];
                list[i] = list[j];
                list[j] = n;
            }
        }
        list[l] = list[j];
        list[j] = m;
        return j;
    }
}
