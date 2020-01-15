package com.zheruomuyi.byteDance.main2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dividend = in.nextInt();
        int divisor = in.nextInt();
        int result = 0;
        //除数为0同样返回0
        if (divisor != 0) {
            while (dividend > divisor) {
                dividend = dividend - divisor;
                result++;
            }
        }
        System.out.println(result);
    }
}
