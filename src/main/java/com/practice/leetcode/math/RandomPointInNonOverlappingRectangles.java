package com.practice.leetcode.math;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/*
    Random Point in Non-overlapping Rectangles

    Solution
    Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformly
    picks an integer point in the space covered by the rectangles.

    Note:
    An integer point is a point that has integer coordinates.
    A point on the perimeter of a rectangle is included in the space covered by the rectangles.
    ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner,
    and [x2, y2] are the integer coordinates of the top-right corner.

    Length and Width of each rectangle does not exceed 2000.
    1 <= rects.length <= 100
    pick return a point as an array of integer coordinates [p_x, p_y]
    pick is called at most 10000 times.

    Example 1:
    Input:
        ["Solution","pick","pick","pick"]
        [[[[1,1,5,5]]],[],[],[]]
    Output:
        [null,[4,1],[4,1],[3,3]]

    Example 2:
    Input:
        ["Solution","pick","pick","pick","pick","pick"]
        [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
    Output:
        [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]

    Explanation of Input Syntax:

    The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument,
    the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */

public class RandomPointInNonOverlappingRectangles {
    public static void main(String[] args) {
        int[][] rects = {{1, 1, 5, 5}};
        Solution obj = new Solution(rects);
        int[] param_1 = obj.pick();
        Arrays.stream(param_1).forEach(System.out::println);
        System.out.println("--------");
        int[] param_2 = obj.pick();
        Arrays.stream(param_2).forEach(System.out::println);
        System.out.println("--------");
        int[] param_3 = obj.pick();
        Arrays.stream(param_3).forEach(System.out::println);
        System.out.println("--------");
        int[] param_4 = obj.pick();
        Arrays.stream(param_4).forEach(System.out::println);
        System.out.println("--------");
    }

    static class Solution {

        Random random;
        TreeMap<Integer,int[]> map;
        int areaSum = 0;

        Solution(int[][] rects) {
            this.random = new Random();
            this.map = new TreeMap<>();

            for (int[] rectangeCoordinates : rects) {
                int length = rectangeCoordinates[2] - rectangeCoordinates[0] + 1; // +1 as we need to consider edges also.
                int breadth = rectangeCoordinates[3] - rectangeCoordinates[1] + 1;

                areaSum += length * breadth;

                map.put(areaSum, rectangeCoordinates);

            }

        }

        int[] pick() {
            int key = map.ceilingKey(random.nextInt(areaSum) + 1); //Don't forget to +1 here, because we need [1,area] while nextInt generates [0,area-1]

            int [] rectangle = map.get(key);

            int length = rectangle[2] - rectangle[0] + 1 ; // +1 as we need to consider edges also.
            int breadth = rectangle[3] - rectangle[1] + 1 ;

            int x = rectangle[0] + random.nextInt(length); //return random length from starting position of x
            int y = rectangle[1] + random.nextInt(breadth); // return random breadth from starting position of y

            return new int[]{x,y};

        }
    }

}
