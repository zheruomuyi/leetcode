package com.zheruomuyi.tree;

import java.util.HashMap;
import java.util.Scanner;

public class BuildTreeFromPreAndIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inorder = new int[n];
        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            preorder[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        TreeNode root =   solution.buildBinaryTree(inorder,preorder);
        solution.prePrintBinaryTree(root);
        System.out.println();
        solution.inPrintBinaryTree(root);
    }

    static class Solution{
        int[] inorder;
        int[] preorder;
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

        TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
            if(preorder.length == 0 || inorder.length != preorder.length){
                return null;
            }
            this.inorder = inorder;
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildBinaryTreeHelper(0,inorder.length-1,0,preorder.length-1);
        }

        private TreeNode buildBinaryTreeHelper(int inBegin, int inEnd, int preBegin, int preEnd) {
            if(inBegin>inEnd || preBegin>preEnd){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preBegin]);
            int mid = this.map.get(preorder[preBegin]);
            root.left = buildBinaryTreeHelper(inBegin,mid-1,preBegin+1,preBegin+mid-inBegin);
            root.right = buildBinaryTreeHelper(mid+1,preEnd,preBegin-inBegin+mid+1,preEnd);
            return root;
        }
    }
}

