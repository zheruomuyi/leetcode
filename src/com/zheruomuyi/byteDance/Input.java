package com.zheruomuyi.byteDance;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    //每行输入带有空格的数字
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine()) - 1;
        int[][] num = new int[count][2];
        for (int i = 0; i < count; i++) {
            String temp = in.nextLine();
            String[] ss = temp.trim().split(" ");
            num[i][0] = Integer.parseInt(ss[0]);
            num[i][1] = Integer.parseInt(ss[1]);
        }
    }

    //输入带有数字和字符串

    //public static void main(String[] args) {
    //    Scanner in = new Scanner(System.in);
    //    int count = in.nextInt();
    //    in.nextLine();
    //    String[] strs = new String[count];
    //    for(int i=0;i<count;i++){
    //        strs[i] = in.nextLine();
    //    }
    //    String strT = in.nextLine();
    //    System.out.println(0);
    //}

    //输入带有数字和符号

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] line = in.nextLine().split(",");
//        int m = Integer.valueOf(line[0]);
//        int k = Integer.valueOf(line[1]);
//    }

    public void testOutput() {
        //数组输出
        int[] numbers = new int[2];
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers));
    // 定义一些变量，用来格式化输出。
        System.out.println(1111);//换行打印
        System.out.print(1111);//不换行打印
        System.out.write(2222);//字节输出
        System.out.printf("%+8.3f\n", 3.14);//按格式输出
    double d = 345.678;
    String s = "你好！";
    int i = 1234;
    // "%"表示进行格式化输出，"%"之后的内容为格式的定义。
        System.out.printf("%f",d);// "f"表示格式化输出浮点数。
        System.out.println();
        System.out.printf("%9.2f",d);// "9.2"中的9表示输出的长度，2表示小数点后的位数。
        System.out.println();
        System.out.printf("%+9.2f",d);// "+"表示输出的数带正负号。
        System.out.println();
        System.out.printf("%-9.4f",d);// "-"表示输出的数左对齐（默认为右对齐）。
        System.out.println();
        System.out.printf("%+-9.3f",d);// "+-"表示输出的数带正负号且左对齐。
        System.out.println();
        System.out.printf("%d",i);// "d"表示输出十进制整数。
        System.out.println();
        System.out.printf("%o",i);// "o"表示输出八进制整数。
        System.out.println();
        System.out.printf("%x",i);// "d"表示输出十六进制整数。
        System.out.println();
        System.out.printf("%#x",i);// "d"表示输出带有十六进制标志的整数。
        System.out.println();
        System.out.printf("%s",s);// "d"表示输出字符串。
        System.out.println();
        System.out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s",d,i,s);
    // 可以输出多个变量，注意顺序。
        System.out.println();
        System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x",i,s);  // "X$"表示第几个变量。     　
         double x = 2.0 / 3;
     // 保留两位小数,用printf与println的不同操作方法
         System.out.println("x is "+(int)(x *100)/100.0);
         System.out.printf("%.2f",x);
    }
}
