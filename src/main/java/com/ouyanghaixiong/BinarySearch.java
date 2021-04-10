package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/4/10
 * @desc
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                right--;
            }
        }

        return -1;
    }

    public int searchLeftBound(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left > n - 1) {
            return -1;
        }
        if (nums[left] != target) {
            return -1;
        }

        return left;
    }

    public int searchRightBound(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0) {
            return -1;
        }
        if (nums[right] != target) {
            return -1;
        }

        return right;
    }

    public int searchLastLessEqual(int[] nums, int target) {
        int n  = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 ) {
            return -1;
        }
        if (nums[right] > target) {
            return -1;
        }

        return right;
    }

    public int searchFirstGreaterEqual(int[] nums, int target) {
        int n  = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left > n - 1) {
            return -1;
        }
        if (nums[left] < target) {
            return -1;
        }

        return left;
    }
}
