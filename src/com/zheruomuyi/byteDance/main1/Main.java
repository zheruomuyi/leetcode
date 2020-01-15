package com.zheruomuyi.byteDance.main1;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] dis = getIntArray(str);
        for(int j = 1; j<dis.length-1;j++) {
            if(dis[j] > dis[j-1] && dis[j] > dis[j+1]){
                System.out.println(dis[j]);
                break;
            }
        }

    }
        static int[] getIntArray(String str){
        String[] array  = str.split(" ");
        int[] b = new int[array.length];
        for(int j = 0; j<b.length;j++) {
            b[j] = Integer.parseInt(array[j]);
        }
        return b;
    }
}
