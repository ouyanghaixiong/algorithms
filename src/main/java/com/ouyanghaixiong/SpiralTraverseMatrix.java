package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class SpiralTraverseMatrix {
    public static void traverse(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }

        int i = 0;
        int j = 0;

        int left = -1;
        int right = n;
        int top = -1;
        int bottom = m;

        while (left <= right && top <= bottom) {
            // 特殊情况
            if (left == right) {
                while (i < bottom) {
                    System.out.println(matrix[i++][j]);
                }
                break;
            }
            if (top == bottom) {
                while (j < right) {
                    System.out.println(matrix[i][j++]);
                }
                break;
            }

            // 从左到右
            while (j < right) {
                System.out.println(matrix[i][j++]);
            }
            i++;
            j--;
            top++;

            // 从上到下
            while (i < bottom) {
                System.out.println(matrix[i++][j]);
            }
            i--;
            j--;
            right--;

            // 从右到左
            while (j > left) {
                System.out.println(matrix[i][j--]);
            }
            i--;
            j++;
            bottom--;

            // 从下到上
            while (i > top) {
                System.out.println(matrix[i--][j]);
            }
            i++;
            j++;
            left++;
        }
    }
}
