package com.practice.leetcode.trees;

/*
    Binary Tree Zigzag Level Order Traversal

    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [1,2,3,7,6,5,4],
           1
        /     \
       2        3
     /   \    /   \
    7    6   5     4
    return its zigzag level order traversal as:
    [
      [1],
      [3,2],
      [7,6,5,4]
    ]

 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class ZigZagTreeTraversal{

      private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();

          // if null then return
          if (root == null) {
              return new ArrayList<>();
          }

          // declare two stacks
          Stack<TreeNode> currentLevel = new Stack<>();
          Stack<TreeNode> nextLevel = new Stack<>();

          // push the root
          currentLevel.push(root);
          boolean leftToRight = true;

          List<Integer> elements = new ArrayList<>();
          // check if stack is empty
          while (!currentLevel.isEmpty()) {



              // pop out of stack
              TreeNode TreeNode = currentLevel.pop();


              elements.add(TreeNode.val);


              // store val according to current
              // order.
              if (leftToRight) {
                  if (TreeNode.left != null) {
                      nextLevel.push(TreeNode.left);
                  }

                  if (TreeNode.right != null) {
                      nextLevel.push(TreeNode.right);
                  }
              }
              else {
                  if (TreeNode.right != null) {
                      nextLevel.push(TreeNode.right);
                  }

                  if (TreeNode.left != null) {
                      nextLevel.push(TreeNode.left);
                  }
              }

              if (currentLevel.isEmpty()) {
                  leftToRight = !leftToRight;
                  Stack<TreeNode> temp = currentLevel;
                  currentLevel = nextLevel;
                  nextLevel = temp;
                  result.add(elements);
                  elements = new ArrayList<>();
              }
          }


          return result;
      }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        System.out.println(zigzagLevelOrder(tree));
    }

}