package com.zheruomuyi.byteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        String str = "/a/b/./../b/c/..";
        Solution solution = new Solution();
        System.out.println(solution.solution(str));
    }

    static class Solution{
        public String solution(String target){
            if(target == null || target.length() <= 1){
                return target;
            }
            String[] strs = target.split("/");
            LinkedList<String> list = new LinkedList<>();
            for (int i = 0; i < strs.length; i++) {
                strs[i] = strs[i].trim();
                if(!strs[i].equals("")){
                    switch (strs[i]){
                        case "..":{
                            if(list.size() > 0){
                                list.pollLast();
                            }
                            break;
                        }
                        case ".":{
                            break;
                        }
                        default:{
                            list.add(strs[i]);
                        }
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if(i ==0 && strs[0].equals("") ){
                    result.append("/");
                }else if(i>0){
                    result.append("/");
                }
                result.append(list.get(i));
            }

            return result.toString();
        }
    }
}
