package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class WeightedGraphWithMatrix {
    private final int v;
    public int[][] vertexes;
    private boolean needCalculation;

    public WeightedGraphWithMatrix(int v) {
        this.v = v;
        this.vertexes = new int[v][v];
        for (int i = 0; i < this.vertexes.length; i++) {
            for (int j = 0; j < this.vertexes[0].length; j++) {
                if (i == j) {
                    this.vertexes[i][j] = 0;
                } else {
                    this.vertexes[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        this.needCalculation = true;
    }

    public void set(int s, int t, int weight) {
        this.vertexes[s][t] = weight;
        this.vertexes[t][s] = weight;
    }

    private void calculateDistance() {
        for (int i = 0; i < this.vertexes.length; i++) {
            for (int j = 0; j < this.vertexes[i].length; j++) {
                int first = this.vertexes[i][j];
                if (first == 0 || first == Integer.MAX_VALUE) {
                    continue;
                }
                for (int k = j + 1; k < this.vertexes[i].length; k++) {
                    int second = this.vertexes[i][k];
                    if (second == 0 || second == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (this.vertexes[i][j] + this.vertexes[i][k] < this.vertexes[j][k]) {
                        this.vertexes[j][k] = this.vertexes[i][j] + this.vertexes[i][k];
                        this.vertexes[k][j] = this.vertexes[i][j] + this.vertexes[i][k];
                    }
                }
            }
        }
    }

    public int floyd(int s, int t) {
        if (needCalculation) {
            needCalculation = false;
            calculateDistance();
        }
        return this.vertexes[s][t];
    }
}
