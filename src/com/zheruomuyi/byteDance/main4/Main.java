package com.zheruomuyi.byteDance.main4;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        while (in.hasNext()) {
            String str = in.nextLine();
            str = str.trim();
            if(str.startsWith("(")){
                str = str.substring(1);
            }
            if(str.endsWith(")")){
                str = str.substring(0,str.length()-1);
            }
            String[] strs = str.split(",");
            ArrayList<String> listA = map.get(strs[0]);
            if(listA == null){
                listA = new ArrayList<String>();
            }
            listA.add(strs[1]);
            ArrayList<String> listB = map.get(strs[1]);
            if(listB == null){
                listB = new ArrayList<String>();
            }
            listB.add(strs[0]);
        }
        ArrayList<String> listA = map.get(A);
        ArrayList<String> listB = map.get(B);
        listA.retainAll(listB);
        System.out.println(A);
    }
}
