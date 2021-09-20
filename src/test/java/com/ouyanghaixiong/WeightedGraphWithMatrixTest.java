package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class WeightedGraphWithMatrixTest {
    private WeightedGraphWithMatrix graph;

    @Before
    public void setUp() throws Exception {
        graph = new WeightedGraphWithMatrix(4);
        graph.set(0, 1, 2);
        graph.set(1, 2, 5);
        graph.set(2, 3, 6);
    }

    @Test
    public void floyd() {
        int min = graph.floyd(0, 2);
        assertEquals(7, min);
    }
}
