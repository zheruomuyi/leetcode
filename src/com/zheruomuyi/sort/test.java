package com.zheruomuyi.sort;

/**
 * @ClassName: test
 * @Description:
 * @author:刘瑾瑾 liujinj@mail.ustc.edu.cn
 * @Date: 2019 18:09
 * @copyright: USTC
 * @version: 1.0
 */

public class test {
    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        int c =5;
//        System.out.println(convert(s,c));
        String str ="aaa";
        String p ="ab*a";
        System.out.println(isMatchs(str,p));
    }

    static Boolean[][]  re;
    public static boolean isMatchs(String s, String p) {
        re =  new Boolean[s.length()+1][p.length()+1];
        return isMatch(0,0,s,p);
    }

    public static boolean isMatch(int i,int j,String s, String p) {
        //boolean flag = p.charAt(j)=='.'||s.charAt(i)==p.charAt(j);
        if(re[i][j]!=null){
           return re[i][j]  = true;
        }
        boolean flag;
        if(p.length()==0){
            return flag = s.length() == 0;
        }else {
            boolean f =( i < s.length() &&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
            if((j+1)<p.length() && p.charAt(j+1)=='*'){
                flag = isMatch(i,j+2,s,p) || (f && isMatch(i+1,j,s,p));
            }else {
                flag = isMatch(i+1,j+1,s,p);
            }
        }

        return re[i][j] = flag;

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int n = s.length();
        int start = 0, end = 0;
        char[] str = new char[2*n+1];
        for (int i = 0; i < s.length(); i++) {
            str[2*i]='#';
            str[2*i+1]=s.charAt(i);
        }
        str[s.length()*2] = '#';
        String st =new String(str);
        System.out.println(st);
        for (int i = 0; i < st.length(); i++) {
            int len = expandAroundCenter(st, i);
            if (len/2 > end - start) {
                System.out.println(len);
                start =(i-1)/2 - (len ) / 4;
                end =(i-1)/2 + (len+2) / 4;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int i) {
        int L = i, R = i;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
            System.out.println("L:"+L+"R:"+R);
        }
        return R - L- 3;
    }

    public static String convert(String s, int numRows) {
        if(s.length()<=0||numRows==1){
            return s;
        }
        int l = (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        int n = s.length()/l;
        for(int i=0;i<numRows;i++){
            if(i==0||i==numRows-1){
                for(int j=0;j<n;j++){
                    sb.append(s.charAt(j*l+i));
                }
                int k = n*l+i;
                if(k<s.length()){
                    sb.append(s.charAt(k));
                }
            }else{
                for(int j=0;j<n;j++){
                    sb.append(s.charAt(j*l+i));
                    int k = j*l+l-i;
                    System.out.println(k);
                    if(k<s.length()){
                        sb.append(s.charAt(k));
                    }

                }

                int k = n*l+i;
                if(k<s.length()){
                    sb.append(s.charAt(k));
                }

                if(n==0){
                    k = l-i;
                    if(k<s.length()){
                        sb.append(s.charAt(k));
                    }
                }
                k = n*l+l-i;
                if(k<s.length()){
                    sb.append(s.charAt(k));
                }
            }

        }

        return sb.toString();
    }


}
