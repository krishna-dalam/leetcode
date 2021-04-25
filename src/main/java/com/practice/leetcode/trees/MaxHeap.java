package com.practice.leetcode.trees;

import java.util.stream.IntStream;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos){
        return  pos/2;
    }

    private int leftChild(int pos){
        return 2 * pos;
    }

    private int rightChild(int pos){
        return  2*pos + 1;
    }

    private boolean isLeaf(int pos){
        return pos >= (size/2) && pos <= size;
    }

    private void swap(int pos1, int pos2){
        int tmp;
        tmp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = tmp;
    }

    private void print(){
        IntStream.range(1, size/2+1).forEach(i ->
            System.out.println("Parent : " + Heap[i] + " Left Child : " + Heap[2*i] + " Right Child : " + Heap[2*i + 1])
        );
    }

    private void insert(int ele){
        Heap[++size] = ele;
        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private int extractMax(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        heapify(1);
        return popped;
    }

    private void heapify(int pos){
        if(isLeaf(pos))
            return;
        if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]){
            if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            }else {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(7);

//        maxHeap.print();

        System.out.println("The max val is " + maxHeap.extractMax());

        maxHeap.print();

    }


}
