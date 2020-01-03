package com.zheruomuyi.tree;

import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] postOrder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            postOrder[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(postOrder, inorder);
        solution.printTreePreOrder(root);
        System.out.println();
        List<Integer> list = solution.preOrderTraversal(root);
        for (Integer i:list) {
            System.out.print(i+" ");
        }
        System.out.println();
        List<Integer> list1 = solution.postOrderTraversal(root);
        for (Integer i:list1) {
            System.out.print(i+" ");
        }
    }

     static class Solution {
        int[] postOrder;
        int[] inorder;
        HashMap<Integer,Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] postOrder, int[] inorder) {
            if(postOrder.length == 0 || postOrder.length != inorder.length){
                return null;
            }
            this.inorder = inorder;
            this.postOrder = postOrder;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildTreeHelper(0,postOrder.length-1,0,inorder.length-1);
        }

         private TreeNode buildTreeHelper(int postOrderLeft, int postOrderRight, int inorderLeft, int inorderRight) {
            if(postOrderLeft>postOrderRight || inorderLeft>inorderRight){
                return null;
            }
             TreeNode root =  new TreeNode(postOrder[postOrderRight]);
            int mid = map.get(postOrder[postOrderRight]);
             root.left = buildTreeHelper(postOrderLeft, postOrderLeft + mid - inorderLeft-1, inorderLeft, mid-1);
             root.right = buildTreeHelper(postOrderLeft + mid - inorderLeft, postOrderRight-1, mid+1, inorderRight);
             return root;
         }

         public List<Integer> preOrderTraversal(TreeNode root) {
             List<Integer> list = new ArrayList<>();
             Stack<TreeNode> stack = new Stack<>();
             TreeNode p = root;
             while(p != null){
                 stack.push(p);
                 p = p.left;
                 while(p == null && !stack.empty()){
                     p = stack.pop();
                     list.add(p.val);
                     p = p.right;
                 }
             }
             return list;
        }
         public List<Integer> postOrderTraversal(TreeNode root) {
             HashSet<TreeNode> set = new HashSet<>();
             List<Integer> list = new ArrayList<>();
             Stack<TreeNode> stack = new Stack<>();
             TreeNode p = root;
             while(p != null){
                 stack.push(p);
                 p = p.left;
                 while((p != null && set.contains(p) && !stack.empty())|| (p == null && !stack.empty())){
                     p = stack.pop();
                     if(p.right == null || set.contains(p.right)) {
                         list.add(p.val);
                         set.add(p);
                         if(!stack.empty())
                             p = stack.pop();
                         else
                             return list;
                     }else {
                         stack.push(p);
                         p = p.right;
                     }
                 }
             }
             return list;
         }

         public void printTreePreOrder(TreeNode root) {
            if(root != null){
                System.out.print(root.val+" ");
                printTreePreOrder(root.left);
                printTreePreOrder(root.right);
            }
         }
     }
}
