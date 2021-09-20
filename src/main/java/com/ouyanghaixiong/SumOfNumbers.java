package com.ouyanghaixiong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class SumOfNumbers {
    public static int[][] getThreeSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return null;
        }
        int n = arr.length;

        for (int i = 0; i <= arr.length - 3; i++) {
            int first = arr[i];
            int[][] twoSumRes = getTwoSum(arr, i + 1, n, target - first);
            if (twoSumRes == null) {
                continue;
            }
            for (int[] twoSum : twoSumRes) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(first);
                tmp.add(twoSum[0]);
                tmp.add(twoSum[1]);
                res.add(tmp);
            }
        }

        return ListToArray(res);
    }

    /**
     * @param arr    有序数组
     * @param target
     * @return
     */
    public static int[][] getTwoSum(int[] arr, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || end - start <= 1) {
            return null;
        }
        int left = start;
        int right = end - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[left]);
                tmp.add(arr[right]);
                res.add(tmp);
                left++;
                right--;
            } else if (sum < target) {
                left++;
                while (left + 1 < end && arr[left] == arr[left + 1]) {
                    left++;
                }
            } else {
                right--;
                while (right - 1 >= start && arr[right] == arr[right - 1]) {
                    right--;
                }
            }
        }

        return res.size() != 0 ? ListToArray(res) : null;
    }

    private static int[][] ListToArray(List<List<Integer>> list) {
        int[][] arr = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;
    }
}
