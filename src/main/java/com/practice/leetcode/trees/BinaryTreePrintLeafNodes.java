package com.practice.leetcode.trees;

public class BinaryTreePrintLeafNodes {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }

    // Recursive Solution
    // print leaf nodes
    public static int printLeafNodes(TreeNode node, boolean isLeft) {
        int sum = 0;
        if(node!=null) {
            if (node.left == null && node.right == null && isLeft) {
                sum += node.data;
            }
            sum+=printLeafNodes(node.left, true);
            sum+=printLeafNodes(node.right, false);
        }
        return sum;
    }



    public static void main(String[] args)
    {
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("Printing leaf nodes in binary tree :");

        int sum = printLeafNodes(rootNode, false);
//        int sum = sumOfLeftLeaves(rootNode);
        System.out.println(sum);
    }

    public static TreeNode createBinaryTree()
    {

        TreeNode rootNode =new TreeNode(3);
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(20);
        TreeNode node3=new TreeNode(15);
        TreeNode node4=new TreeNode(7);

        rootNode.left=node1;
        rootNode.right=node2;

        node2.left=node3;
        node2.right=node4;

        return rootNode;
    }

//    public static int sumOfLeftLeaves(TreeNode root) {
//        int res = 0;
//
//        // Update result if root is not NULL
//        if (root != null)
//        {
//            // If left of root is NULL, then add key of
//            // left child
//            if (isLeaf(root.left))
//                res += root.left.data;
//            else // Else recur for left child of root
//                res += sumOfLeftLeaves(root.left);
//
//            // Recur for right child of root and update res
//            res += sumOfLeftLeaves(root.right);
//        }
//
//        // return result
//        return res;
//    }
//    static boolean isLeaf(TreeNode node)
//    {
//        if (node == null)
//            return false;
//        if (node.left == null && node.right == null)
//            return true;
//        return false;
//    }
}
