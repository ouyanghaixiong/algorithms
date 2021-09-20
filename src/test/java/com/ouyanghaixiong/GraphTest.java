package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph(10);
        graph.set(0, 1);
        graph.set(1, 2);
        graph.set(1, 3);
        graph.set(2, 4);
        graph.set(3, 4);
        graph.set(4, 5);
        graph.set(5, 6);
        graph.set(3, 6);
        graph.set(6, 7);
        graph.set(6, 8);
        graph.set(7, 9);
        graph.set(8, 9);
    }

    @Test
    public void dfs() {
        graph.dfs();
    }

    @Test
    public void bfs() {
        graph.bfs();
    }
}
