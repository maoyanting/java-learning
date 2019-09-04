package com.sandao.javalearning.algorithm.leetcode;

import java.util.*;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class Solution199 {
    /**
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     * <p>
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
//        System.out.println(rightSideView(root));
        System.out.println(rightSideViewMySelf(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        /* These two stacks are always synchronized, providing an implicit
         * association values with the same offset on each stack. */
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                /* The first node that we encounter at a particular depth contains
                 * the correct value. */
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        /* Construct the solution based on the values that we end up with at the
         * end. */
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    public static List<Integer> rightSideViewMySelf(TreeNode root){
        //要找每一层最右边的数字，所以每个数字都需要遍历
        List<Integer> rightView = new LinkedList<>();
        if (root == null){
            return rightView;
        }
        List<TreeNode> currentNodeList = new LinkedList<>();
        List<TreeNode> nextNodeList =new LinkedList<>();
        currentNodeList.add(root);
        rightView.add(root.val);
        int i = 0;
        while (currentNodeList.size() != 0){
            TreeNode node = currentNodeList.get(i);

            if (node.left != null){
                nextNodeList.add(node.left);
            }
            if (node.right != null){
                nextNodeList.add(node.right);
            }
            if (i == currentNodeList.size()-1 ){
                i = 0;
                currentNodeList = nextNodeList;
                if (nextNodeList.size() != 0){
                    rightView.add(nextNodeList.get(nextNodeList.size()-1).val);
                }
                nextNodeList = new LinkedList<>();
            }else {
                i++;
            }
        }
        return rightView;
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
}
