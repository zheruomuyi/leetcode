package com.zheruomuyi.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: BaseSort
 * @author: jinjin.Liu
 * @Date: 2019/12/31
 */
public class BaseSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        baseSort(list);
        for (int i = 0; i < n; i++) {
            System.out.print(list[i]+" ");
        }

    }

    private static void baseSort(int[] list) {
        ArrayList<Queue<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Queue<Integer> que = new LinkedList<>();
            queue.add(que);
        }
        int max = Integer.MIN_VALUE;
        for (int item : list) {
            max = Math.max(max, item);
        }
        int v = 0;
        if(max>0){
            while(max > 0){
                max = max/10;
                v++;
            }
        }
        for (int i = 0; i < v; i++) {
            for (int value : list) {
                int x = value % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                Queue<Integer> que1 = queue.get(x);
                que1.offer(value);
                queue.set(x, que1);
            }
            int count = 0;
            for (int j = 0; j < 10; j++) {
                Integer s;
                while((s = queue.get(j).poll()) != null){
                    list[count++] = s;
                }
            }
        }
    }
}
