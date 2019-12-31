package com.zheruomuyi.sort;

/**
 * @ClassName: testThree
 * @Description:
 * @author:刘瑾瑾 liujinj@mail.ustc.edu.cn
 * @Date: 2019 17:51
 * @copyright: USTC
 * @version: 1.0
 */
public class testThree {
    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        for (int num:nums) {
            System.out.print(num);
        }

    }
        public static void nextPermutation(int[] nums) {
            if(nums.length<=1){
                return;
            }
            if(nums.length==2){
                if(nums[1]>nums[0]){
                    int a = nums[1];
                    nums[1] = nums[0];
                    nums[0] = a;
                    return;
                }else{
                    return;
                }
            }
            boolean flag = false;
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    int a = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = a;
                    System.out.println(i+"\n");
                    if(i<nums.length-1){
                        int k = i;
                        for(int j=k;j<nums.length-1;j++){
                            for(int l=j+1;l<nums.length;l++){
                                if(nums[j]>nums[l]){
                                    a = nums[j];
                                    nums[j] = nums[l];
                                    nums[l] = a;
                                }
                            }
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if(flag != true){

                for(int i=0;i<=nums.length/2;i++){
                    int a = nums[i];
                    nums[i] = nums[nums.length-i-1];
                    nums[nums.length-i-1] = a;
                }
            }
        }

}
