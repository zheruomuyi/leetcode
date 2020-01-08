package com.zheruomuyi.tree;

import java.util.*;

public class LevelTraversalTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.trim();
        String[] tree = str.split(" ");
        int[] levelOrder = new int[tree.length];
        for (int i = 0; i < levelOrder.length; i++) {
            if ("null".equals(tree[i])){
                levelOrder[i] = -1;
            }else {
                levelOrder[i] = Integer.parseInt(tree[i]);
            }
        }
        Solution solution = new Solution();
        TreeNode root =   solution.buildBinaryTree(levelOrder);
        solution.prePrintBinaryTree(root);
        System.out.println();
        System.out.println(solution.findBottomLeftValueTwo(root));
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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> queue1 = new LinkedList<>();
            TreeNode p = root;
            queue.add(p);
            int left = -1;
            while(!queue.isEmpty()){
                p = queue.peek();
                left = p.val;
                while (!queue.isEmpty()){
                    p = queue.poll();
                    if(p.left != null ){
                        queue1.offer(p.left);
                    }
                    if(p.right != null ) {
                        queue1.offer(p.right);
                    }
                }
                while (!queue1.isEmpty()){
                    p = queue1.poll();
                    queue.offer(p);
                }
            }
            return left;
        }
        int left = -1;
        int max = 0;
        public int findBottomLeftValueTwo(TreeNode root) {
            def(root,0);
            return left;
        }

        private void def(TreeNode root, int h) {
            if(root == null){
                return;
            }
            h++;
            if (h>max){
                max = h;
                left = root.val;
            }
            def(root.left,h);
            def(root.right,h);
        }
    }
}
