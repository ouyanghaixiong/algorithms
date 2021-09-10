package com.ouyanghaixiong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/10
 * @desc
 */
public class AStar {
    protected static class Grid {
        // 以左上角为(0, 0)
        public final int x;
        public final int y;

        public int G;

        // 用于记录从哪个格子达到当前格子的
        public Grid prev;

        public Grid(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getF() {
            return G + getH();
        }

        public int getH() {
            return Math.abs(this.x - endX) + Math.abs(this.y - endY);
        }

        public boolean isEnd() {
            return this.x == endX && this.y == endY;
        }
    }

    private final static Set<Grid> openList = new HashSet<>();
    private final static Set<Grid> closeList = new HashSet<>();

    private static final int startX = 1;
    private static final int startY = 2;
    private static final int endX = 5;
    private static final int endY = 2;

    public static final Grid[][] mist = buildMist();

    private static Grid[][] buildMist() {
        int height = 5;
        int width = 7;
        Grid[][] mist = new Grid[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // 这是普通方格
                mist[y][x] = new Grid(y, x);
                // 这是围墙
                if (x == 3 && y >= 1 && y <= 3) {
                    mist[y][x] = null;
                }
            }
        }

        return mist;
    }

    private static Grid getDestination() {
        // 从起点开始
        Grid cur = mist[startY][startX];
        cur.G = 0;
        openList.add(cur);

        // 开始循环, 直到openList中没有元素
        while (!openList.isEmpty()) {
            // 从openList取出当前F最小的格子, 记为当前格子, 如果当前格子是终点, 跳出循环
            cur = findMinF();

            // 将当前格子加入closeList, 从openList中删除
            closeList.add(cur);
            openList.remove(cur);

            // 查看当前格子的上下左右, 对其中有效的格子, 计算G并赋值, 将该格子加入到openList
            List<Grid> validAdjacentGrids = getValidAdjacentGrids(cur);
            for (Grid grid : validAdjacentGrids) {
                grid.G = cur.G + 1;
                grid.prev = cur;
                openList.add(grid);
            }

            // 如果重点在openList中, 退出循环, 将当前格子指向重点
            for (Grid grid : openList) {
                if (grid.isEnd()) {
                    return grid;
                }
            }

        }
        // 循环结束, 没有找到重点
        return null;
    }

    public static void printPath() {
        Grid dest = getDestination();
        helper(dest);
    }

    private static void helper(Grid grid) {
        if (grid.prev != null) {
            helper(grid.prev);
        }
        System.out.println("(" + grid.y + "," + grid.x + ")");
    }

    /**
     * @return 从openList中找到F最小的那个格子
     */
    private static Grid findMinF() {
        int min = Integer.MAX_VALUE;
        Grid minFGrid = null;
        for (Grid grid : openList) {
            int curF = grid.getF();
            if (curF < min) {
                min = curF;
                minFGrid = grid;
            }
        }

        return minFGrid;
    }

    /**
     * 获取当前格子上下左右格子中有效的格子
     *
     * @param grid 当前格子
     * @return 只有不是墙而且没有出现在openList 或 closeList中的格子才是有效的格子
     */
    private static List<Grid> getValidAdjacentGrids(Grid grid) {
        System.out.println("cur " + grid.y + " " + grid.x);
        ArrayList<Grid> validAdjacentGrids = new ArrayList<>();
        // 上格子
        if (grid.y - 1 >= 0 && mist[grid.y - 1][grid.x] != null) {
            Grid top = mist[grid.y - 1][grid.x];
            System.out.println("top " + (grid.y - 1) + " " + grid.x);
            if (isValid(top)) {
                validAdjacentGrids.add(top);
            }
        }
        // 下格子
        if (grid.y + 1 < mist.length && mist[grid.y + 1][grid.x] != null) {
            Grid bottom = mist[grid.y + 1][grid.x];
            System.out.println("bottom " + (grid.y + 1) + " " + grid.x);
            if (isValid(bottom)) {
                validAdjacentGrids.add(bottom);
            }
        }
        // 左格子
        if (grid.x - 1 >= 0 && mist[grid.y][grid.x - 1] != null) {
            Grid left = mist[grid.y][grid.x - 1];
            System.out.println("left " + (grid.y) + " " + (grid.x - 1));
            if (isValid(left)) {
                validAdjacentGrids.add(left);
            }
        }
        // 右格子
        if (grid.x + 1 < mist[0].length && mist[grid.y][grid.x + 1] != null) {
            Grid right = mist[grid.y][grid.x + 1];
            System.out.println("right " + (grid.y) + " " + (grid.x + 1));
            if (isValid(right)) {
                validAdjacentGrids.add(right);
            }
        }

        return validAdjacentGrids;
    }

    private static boolean isValid(Grid grid) {
        return !openList.contains(grid) && !closeList.contains(grid);
    }
}
