package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class WeightedGraphTest {
    private WeightedGraph graph;

    @Before
    public void setUp() throws Exception {
        graph = new WeightedGraph(10);
        graph.set(0, 1, 3);
        graph.set(1, 2, 3);
        graph.set(1, 3, 5);
        graph.set(2, 4, 2);
        graph.set(3, 4, 4);
        graph.set(4, 5, 2);
        graph.set(5, 6, 7);
        graph.set(3, 6, 4);
        graph.set(6, 7, 6);
        graph.set(6, 8, 10);
        graph.set(7, 9, 6);
        graph.set(8, 9, 2);
    }

    @Test
    public void print() {
        for (WeightedGraph.Vertex vertex : graph.vertexes) {
            System.out.println(vertex.edges.size());
        }
    }

    @Test
    public void dijkstra() {
        graph.dijkstra(0, 9);
    }
}
