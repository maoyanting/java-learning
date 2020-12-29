package com.sandao.javalearning.algorithm.offer;


import java.util.ArrayList;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/14
 */
public class Backtracking {
    /**
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     */
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.right = new TreeNode(5);
        node3.right = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        System.out.println(FindPath(root,8));
    }

    private static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking2(root, target, new ArrayList<>());
        return ret;
    }

    private static void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    private static void backtracking2(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null && target == 0){
            ret.add(new ArrayList<>(path));
            return;
        }
        if (node == null){
            return;
        }
        target = target-node.val;
        path.add(node.val);
        backtracking2(node.left,target,path);
        backtracking2(node.right,target,path);
        path.remove(path.size() - 1);
    }
}
