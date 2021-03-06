package com.sandao.javalearning.thread;

import lombok.Data;

import java.util.Arrays;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/05/20
 */
public class TreeNodeGenerate2 {

    @Data
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.value = value;
        }

        public Boolean hasRight(){
            return this.right != null;
        }

        public Boolean hasLeft(){
            return this.right != null;
        }

        public void insert(int value){
            TreeNode current =  new TreeNode(value);
            if (this.value > value){
                //走右边
                if (hasRight()){
                    TreeNode node = this.getRight();
                    node.insert(value);
                }else {
                    this.right = current;
                }
            }else {
                //走左边
                if (hasLeft()){
                    TreeNode node = this.getLeft();
                    node.insert(value);
                }else {
                    this.right = current;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 5, 4, 7, 9};
        Arrays.sort(intArray);
//        TreeNode treeNode = new TreeNode(intArray[0]);
//        for (int i : intArray){
//            treeNode.insert(i);
//        }
    }
}
