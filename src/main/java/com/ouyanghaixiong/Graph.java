package com.ouyanghaixiong;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class Graph {
    private final LinkedList<Integer>[] adj;
    private final int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void set(int s, int t) {
        for (int i = 0; i < adj[s].size(); i++) {
            if (adj[s].get(i).equals(t)) {
                return;
            }
        }
        adj[s].add(t);
    }

    public void dfs() {
        boolean[] visited = new boolean[this.v];
        dfsHelper(0, visited);
    }

    private void dfsHelper(int cur, boolean[] visited) {
        visited[cur] = true;
        System.out.println(cur);

        for (int i = 0; i < adj[cur].size(); i++) {
            if (visited[adj[cur].get(i)]) {
                continue;
            }
            dfsHelper(adj[cur].get(i), visited);
        }
    }

    public void bfs() {
        boolean[] visited = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!visited[cur]) {
                System.out.println(cur);
            }
            visited[cur] = true;
            for (int i = 0; i < adj[cur].size(); i++) {
                if (visited[adj[cur].get(i)]) {
                    continue;
                }
                queue.offer(adj[cur].get(i));
            }
        }
    }
}
