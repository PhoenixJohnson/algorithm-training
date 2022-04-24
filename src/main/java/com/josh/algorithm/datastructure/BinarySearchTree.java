package com.josh.algorithm.datastructure;


import com.josh.algorithm.common.Tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
二分查找树，是个二叉树，每个节点左侧都小于它， 右边的元素都大于它
BST
 */
public class BinarySearchTree {

    private Tree rootNode;
    private int count = 0;


    public BinarySearchTree() {
        rootNode = new Tree(0, 10, null,null);
        count = 0;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int findMinKey(Tree input) {
        if(null == input.getLeftNode()) {
            return input.getKey();
        } else {
            return findMinKey(input.getLeftNode());
        }
    }

    public int findMaxKey(Tree input) {
        if(null == input.getRightNode()) {
            return input.getKey();
        } else {
            return findMaxKey(input.getRightNode());
        }
    }

    //广度优先遍历
    /*
        需要引入一个队列
     */

    public void LevelPrintTree(Tree inputNode) {

        System.out.println("广度优先遍历 -- 层序输出");

        Queue<Tree> queue = new LinkedBlockingQueue<>();
        queue.add(inputNode);

        while(!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.println("###########      "+ node.getKey()+" + "+node.getValue() +"     ###########");

            if(null != node.getLeftNode()) {
                queue.add(node.getLeftNode());
            }

            if(null != node.getRightNode()) {
                queue.add(node.getRightNode());
            }
        }


    }

    //深度优先遍历
    //前序，中序，后续
    public void printTree(Tree inputNode){

        if(inputNode == null) {
            return;
        }
        printTree(inputNode.getLeftNode());
        System.out.println("###########      "+ inputNode.getKey()+" + "+inputNode.getValue() +"     ###########");
        printTree(inputNode.getRightNode());
    }

    public int search(Tree inputTree, int value) {

        if(inputTree == null) {
            return -1;
        }

        if(inputTree.getValue() == value) {
            return inputTree.getKey();
        } else if(value > inputTree.getValue()) {
            return search(inputTree.getRightNode(), value);
        } else {
            return search(inputTree.getLeftNode(), value);
        }

    }

    public Tree insert(Tree inputNode, int key, int value) {

        if(inputNode == null){
            count++;
            return new Tree(key, value);
        }

        if(inputNode.getValue() == value) {
            inputNode.setValue(value);
        } else if(inputNode.getValue()< value){
            inputNode.setRightNode(insert(inputNode.getRightNode(), key, value));
        } else {
            inputNode.setLeftNode(insert(inputNode.getLeftNode(), key,value));
        }

        return inputNode;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(bst.rootNode, 1,5);
        bst.insert(bst.rootNode, 2,12);
        bst.insert(bst.rootNode, 3,17);
        bst.insert(bst.rootNode, 4,7);
        bst.insert(bst.rootNode, 5,9);
        bst.insert(bst.rootNode, 6,23);
        bst.insert(bst.rootNode, 7,16);
//        System.out.println(bst.search(bst.rootNode, 51));
        System.out.println("深度优先遍历 -- 中序输出");
        bst.printTree(bst.rootNode);
        bst.LevelPrintTree(bst.rootNode);
        System.out.println("最小值的下标为 -- ");
        System.out.println(bst.findMinKey(bst.rootNode));
        System.out.println("最大值为的下标为 -- ");
        System.out.println(bst.findMaxKey(bst.rootNode));
    }


}
