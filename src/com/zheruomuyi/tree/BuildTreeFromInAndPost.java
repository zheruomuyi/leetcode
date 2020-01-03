package com.zheruomuyi.tree;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: BuildTreeFromInAndPost
 * @author: jinjin.Liu
 * @Date: 2020/1/2
 */
public class BuildTreeFromInAndPost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postorder[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        TreeNode root =   solution.buildBinaryTree(inorder,postorder);
        solution.prePrintBinaryTree(root);
        System.out.println();
        solution.inPrintBinaryTree(root);
    }
    static class Solution{
        int[] inorder;
        int[] postorder;
        HashMap<Integer,Integer> map = new HashMap<>();
        void inPrintBinaryTree(TreeNode root) {
            if(root != null){
                inPrintBinaryTree(root.left);
                System.out.print(root.val+" ");
                inPrintBinaryTree(root.right);
            }
        }

        void prePrintBinaryTree(TreeNode root) {
            if(root != null){
                System.out.print(root.val+" ");
                prePrintBinaryTree(root.left);
                prePrintBinaryTree(root.right);
            }
        }

        TreeNode buildBinaryTree(int[] inorder, int[] postorder) {
            if(postorder.length == 0 || inorder.length != postorder.length){
                return null;
            }
            this.inorder = inorder;
            this.postorder = postorder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildBinaryTreeHelper(0,inorder.length-1,0,postorder.length-1);
        }

        private TreeNode buildBinaryTreeHelper(int inBegin, int inEnd, int postBegin, int postEnd) {
            if(inBegin>inEnd || postBegin>postEnd){
                return null;
            }
            TreeNode root = new TreeNode(postorder[postBegin]);
            int mid = this.map.get(postorder[postBegin]);
            root.left = buildBinaryTreeHelper(inBegin,mid-1,postBegin+1,postBegin+mid-inBegin);
            root.right = buildBinaryTreeHelper(mid+1,postEnd,postBegin-inBegin+mid+1,postEnd);
            return root;
        }
    }
}

