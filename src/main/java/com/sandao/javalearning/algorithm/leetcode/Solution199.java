package com.sandao.javalearning.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 重复
 *
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
        System.out.println(leftSideViewMySelf(root));
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
        List<TreeNode> currentTreeNodes = Lists.newLinkedList();
        List<TreeNode> nextTreeNodes = Lists.newLinkedList();
        List<Integer> rightSide = Lists.newLinkedList();
        currentTreeNodes.add(root);
        int i = 0;
        while(!currentTreeNodes.isEmpty()){
            TreeNode treeNode = currentTreeNodes.get(i);
            if (treeNode.left != null){
                nextTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null){
                nextTreeNodes.add(treeNode.right);
            }
            if (i == currentTreeNodes.size()-1){
                currentTreeNodes = nextTreeNodes;
                nextTreeNodes = Lists.newLinkedList();
                i = 0;
                rightSide.add(treeNode.val);
            }else {
                i++;
            }
        }
       return rightSide;
    }

    public static List<Integer> leftSideViewMySelf(TreeNode root){
        //要找每一层最右边的数字，所以每个数字都需要遍历
        List<TreeNode> currentTreeNodes = Lists.newLinkedList();
        List<TreeNode> nextTreeNodes = Lists.newLinkedList();
        List<Integer> rightSide = Lists.newLinkedList();
        currentTreeNodes.add(root);
        int i = 0;
        while(!currentTreeNodes.isEmpty()){
            TreeNode treeNode = currentTreeNodes.get(i);
            if (treeNode.left != null){
                nextTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null){
                nextTreeNodes.add(treeNode.right);
            }
            if (i == 0){
                rightSide.add(treeNode.val);
            }
            if (i == currentTreeNodes.size()-1){
                currentTreeNodes = nextTreeNodes;
                nextTreeNodes = Lists.newLinkedList();
                i = 0;
            }else {
                i++;
            }
        }
        return rightSide;
    }

}
