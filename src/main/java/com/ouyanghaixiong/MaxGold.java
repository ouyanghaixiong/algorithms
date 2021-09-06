package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/6
 * @desc 最多的金子
 */
public class MaxGold {
    private static final int[] golds = {200, 300, 350, 400, 500};
    private static final int[] labors = {3, 4, 3, 5, 5};
    private static final int numGoldMine = 5;
    private static final int numLabels = 10;

    public static int get() {
        int[] dp = new int[numLabels + 1];

        // base case
        for (int j = 0; j < numLabels; j++) {
            if (j < labors[0]) {
                dp[j] = 0;
            } else {
                dp[j] = golds[0];
            }
        }

        for (int i = 1; i < numGoldMine; i++) {
            for (int j = numLabels; j >= 0; j--) {
                if (j < labors[i]) {
                    continue;
                }
                dp[j] = Math.max(dp[j - labors[i]] + golds[i], dp[j]);
            }
        }

        return dp[numLabels];
    }
}
