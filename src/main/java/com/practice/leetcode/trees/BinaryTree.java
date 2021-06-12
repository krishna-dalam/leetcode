package com.practice.leetcode.trees;

class Node {
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

// Class Index created to implement pass by reference of Index
class Index {
    int index;
}

class BinaryTree {
    /* Recursive function to construct binary of size n
       from  Inorder traversal in[] and Postrder traversal
       post[].  Initial values of inStrt and inEnd should
       be 0 and n -1.  The function doesn't do any error
       checking for cases where inorder and postorder
       do not form a tree */
    Node buildUtil(int in[], int post[], int inStrt,
                   int inEnd, Index pIndex)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        Node node = new Node(post[pIndex.index]);
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = search(in, inStrt, inEnd, node.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex);
        node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex);

        return node;
    }

    // This function mainly initializes index of root
    // and calls buildUtil()
    Node buildTree(int in[], int post[], int n)
    {
        Index pIndex = new Index();
        pIndex.index = n - 1;
        return buildUtil(in, post, 0, n - 1, pIndex);
    }

    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[] */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    /* This funtcion is here just to test  */
    void inOrder(Node node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        int in[] = new int[] { 9, 3, 15, 20, 7 };
        int post[] = new int[] { 9, 15, 7, 20, 3 };
        int len = in.length;
        Node root = tree.buildTree(in, post, len);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inOrder(root);
    }
}

// This code has been contributed by Mayank Jaiswal

