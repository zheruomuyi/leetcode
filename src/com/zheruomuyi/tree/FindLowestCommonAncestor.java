package com.zheruomuyi.tree;

import java.util.*;

public class FindLowestCommonAncestor {
    public static void main(String[] args) {
        String str = "-1 0 3 -2 4 null null 8";
        System.out.println(str.substring(0,str.indexOf("a")));
//        str = str.trim();
//        String[] tree = str.split(" ");
//        int[] levelOrder = new int[tree.length];
//        for (int i = 0; i < levelOrder.length; i++) {
//            if (tree[i].equals("null")){
//                levelOrder[i] = -1;
//            }else {
//                levelOrder[i] = Integer.parseInt(tree[i]);
//            }
//        }
//        Solution solution = new Solution();
//        TreeNode root =   solution.buildBinaryTree(levelOrder);
//        solution.prePrintBinaryTree(root);
//        System.out.println();
//        TreeNode p = root.left.left.left;
//        TreeNode q = root.left.right;
//        System.out.println(solution.lowestCommonAncestor(root,p,q).val);

    }

    static class Solution{
        void prePrintBinaryTree(TreeNode root) {
            if(root != null){
                System.out.print(root.val+" ");
                prePrintBinaryTree(root.left);
                prePrintBinaryTree(root.right);
            }
        }

        TreeNode buildBinaryTree(int[] levelOrder) {
            if(levelOrder.length == 0 ){
                return null;
            }
            TreeNode root = new TreeNode(levelOrder[0]);
            List<TreeNode> list = new ArrayList<>(levelOrder.length);
            list.add(0,root);
            for (int i = 1; i < levelOrder.length; i++) {
                if (levelOrder[i] != -1){
                    TreeNode p = new TreeNode(levelOrder[i]);
                    list.add(i,p);
                    TreeNode r = list.get((i-1)/2);
                    if (i%2 == 1){
                        r.left = p;
                    }else {
                        r.right = p;
                    }
                }else{
                    list.add(i,null);
                }
            }
            return root;
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(contains(root.left,q) && contains(root.left,p)){
                return lowestCommonAncestor(root.left,p,q);
            }else if(contains(root.right,q) && contains(root.right,p)){
                return lowestCommonAncestor(root.right,p,q);
            }else
                return root;
        }
        public boolean contains(TreeNode root,TreeNode p){
            if(root == p)
                return true;
            if(root == null)
                return false;
            return contains(root.left, p) || contains(root.right, p);
        }
    }
}
