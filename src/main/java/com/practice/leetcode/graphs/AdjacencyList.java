package com.practice.leetcode.graphs;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class AdjacencyList {
    private static class Graph{
        private static ArrayList<ArrayList<Integer>> graph;

        Graph(int V){
            graph = new ArrayList<>(V);
        }

        static void addEdge(int u, int v){
            graph.get(u).add(v);
            graph.get(v).add(v);
        }

        static void print(){
            IntStream.range(0, graph.size()).forEach(i -> {
                        System.out.println("\nAdjacency list of vertex" + i);
                        IntStream.range(0, graph.get(i).size()).forEach( e -> System.out.println(e));
                    });
        }

    }
}
