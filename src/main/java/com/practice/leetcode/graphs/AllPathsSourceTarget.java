package com.practice.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/*
    All Paths From Source to Target

    Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

    The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

        Example:
            Input: [[1,2], [3], [3], []]
            Output: [[0,1,3],[0,2,3]]
                Explanation: The graph looks like this:
                0--->1
                |    |
                v    v
                2--->3
                There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

     Note:
         The number of nodes in the graph will be in the range [2, 15].
         You can print different paths in any order, but you should keep the order of nodes inside one path.

 */

public class AllPathsSourceTarget {
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);
        return res;
    }
    private static void dfs(int[][] graph, int index, List<List<Integer>> res, List<Integer> path) {
        // base case
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[index]) {
            path.add(next);
            dfs(graph, next, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};

        System.out.println(allPathsSourceTarget(graph).toString());












    }

}
