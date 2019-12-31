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
        DoQuickSort(list,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(list[i]+" ");
        }
    }

    private static void DoQuickSort(int[] list, int i, int j) {
        if(i>=j) {
            return;
        }
        int x=i,y=j;
        int model = findModel(list ,i ,j);
        DoQuickSort(list,x,model-1);
        DoQuickSort(list,model+1, y);
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
