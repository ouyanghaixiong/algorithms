package com.ouyanghaixiong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class WeightedGraph {
    protected static class Vertex implements Comparable<Vertex> {
        public int data;
        public int distance;
        public boolean visited;
        public LinkedList<Edge> edges;

        public Vertex(int data) {
            this.data = data;
            this.distance = Integer.MAX_VALUE;
            this.visited = false;
            this.edges = new LinkedList<>();
        }

        public Vertex() {
            this.distance = Integer.MAX_VALUE;
            this.visited = false;
            this.edges = new LinkedList<>();
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }
    }

    private static class Edge {
        public final Vertex next;
        private final Integer weight;

        public Edge(Vertex next, Integer weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    private final int v;
    public final Vertex[] vertexes;

    public WeightedGraph(int v) {
        this.v = v;
        this.vertexes = new Vertex[v];
        for (int i = 0; i < v; i++) {
            vertexes[i] = new Vertex(i);
        }
    }

    public void set(int s, int t, int weight) {
        // 先查找这两个顶点是否已经存在连接
        for (int i = 0; i < vertexes[s].edges.size(); i++) {
            Edge edge = vertexes[s].edges.get(i);
            if (edge.next.data == t) {
                return;
            }
        }

        vertexes[s].addEdge(new Edge(vertexes[t], weight));
    }

    public void dijkstra(int s, int t) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        vertexes[0].distance = 0;
        queue.offer(vertexes[s]);
        int[] prev = new int[v];
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            cur.visited = true;
            if (cur.data == t) {
                break;
            }
            for (Edge edge : cur.edges) {
                Vertex adj = edge.next;
                if (cur.distance + edge.weight < adj.distance) {
                    adj.distance = cur.distance + edge.weight;
                    prev[adj.data] = cur.data;
                    if (!adj.visited) {
                        queue.offer(adj);
                    }
                }
            }
        }
        printPath(prev, s, t);
        System.out.println(Arrays.toString(prev));
    }

    private void printPath(int[] prev, int s, int t) {
        if (s == t) {
            System.out.println(t);
            return;
        }

        printPath(prev, s, prev[t]);
        System.out.println(t);
    }
}
