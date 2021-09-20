package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class SpiralTraverseMatrixTest {

    @Test
    public void traverse() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralTraverseMatrix.traverse(matrix);
    }
}
