package com.zheruomuyi.sort;

import java.util.Scanner;
/**
 * @ClassName: InsertSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class InsertSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
        }
        insertSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    public static void insertSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            int n = list[i];
            int j=i;
            for (; j >0; j--) {
                if(n < list[j-1]){
                    list[j] = list[j-1];
                }else{
                    break;
                }
            }
            list[j] = n;
        }
    }
}
