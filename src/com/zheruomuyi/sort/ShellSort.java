package com.zheruomuyi.sort;

import java.util.Scanner;

/**
 * @ClassName: ShellSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
        }
        shellSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }
    }

    private static void shellSort(int[] list) {
        for (int i = list.length/2; i > 0 ; i /= 2) {
            for(int j = i; j < list.length; j++){
                int m = list[j];
                int k = j-i;
                for (; k >= 0; k -= i) {
                    if(list[k]>m){
                        list[k+i] = list[k];
                    }else{
                        break;
                    }
                }
                list[k+i] = m;
            }
        }
    }
}
