package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Sum of Root To Leaf Binary Numbers

    You are given the root of a binary tree where each node has a value 0 or 1.
    Each root-to-leaf path represents a binary number starting with the most significant bit.
    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

    Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.

    Example 1:
               1
            /     \
          0         1
         / \       / \
        0    1    0    1
    Input: root = [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

    Example 2:
    Input: root = [0]
    Output: 0

    Example 3:
    Input: root = [1]
    Output: 1

    Example 4:
    Input: root = [1,1]
    Output: 3

    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    Node.val is 0 or 1.

 */
public class SumOfRootToLeafBinaryNumbers {

    private static class TreeNode {
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
    //[ 1, 0, 1, 0 1, 0, 1]
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(0, null, null);
        TreeNode l2 = new TreeNode(1, null, null);
        TreeNode l3 = new TreeNode(0, null, null);
        TreeNode l4 = new TreeNode(1, null, null);

        TreeNode m1 = new TreeNode(0, l1, l2);
        TreeNode m2 = new TreeNode(1, l3, l4);

        TreeNode root = new TreeNode(1, m1, m2);

        System.out.println(sumRootToLeaf(root));
    }

    private static int sumRootToLeaf(TreeNode root) {
        return calculateSum(root, "");
    }

    private static int calculateSum(TreeNode node, String runningSum) {

        if(node.left == null && node.right == null)
            return Integer.parseInt(runningSum + node.val, 2);

        return calculateSum(node.left, runningSum + node.val) +
        calculateSum(node.right, runningSum + node.val);

    }

}
