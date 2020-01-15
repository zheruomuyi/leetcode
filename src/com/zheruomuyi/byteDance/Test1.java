package com.zheruomuyi.byteDance;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int[] target = {3,1,5,8};
        Solution solution = new Solution();
        System.out.println(solution.solution(target));
    }

    static class Solution{
        public int solution(int[] target){
            if(target == null || target.length < 1){
                return 1;
            }
            int sum = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for (int value : target) {
                list.add(value);
            }
            while(list.size()>2) {
                int min = list.get(1);
                int l = 1;
                int c = 1;
                for (int i = 1; i < list.size()-1; i++) {
                    if(list.get(i) <= min){
                        c = list.get(i-1) *  list.get(i) *  list.get(i+1);
                        min = list.get(i);
                        l = i;
                    }
                }
                list.remove(l);
                sum += c;
            }
            if( list.size() == 2){
                sum += list.get(0) * list.get(1);
                if(list.get(0) > list.get(1)){
                    list.remove(1);
                }else{
                    list.remove(0);
                }
            }
            if( list.size() == 1){
                sum = sum + list.get(0);
                return sum;
            }
            return sum;
        }
    }
}
