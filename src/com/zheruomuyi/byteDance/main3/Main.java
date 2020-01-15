package com.zheruomuyi.byteDance.main3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toString();
        if(str.startsWith("[")){
            str = str.substring(1);
        }
        if(str.endsWith("]")){
            str = str.substring(0,str.length()-1);
        }
        String[] arr  = str.split(",");
        int[] a = new int[arr.length];
        for(int j = 0; j<a.length;j++) {
            a[j] = Integer.parseInt(arr[j]);
        }
        int left = 0;
        for(int j = 0; j<a.length;j++) {
             if(a[j] < 0){
                int n = a[j];
                if (j - left >= 0) {
                    System.arraycopy(a, left, a, left + 1, j - left);
                }
                a[left++] = n;
            }
        }
        System.out.println(Arrays.toString(a));

    }
}
