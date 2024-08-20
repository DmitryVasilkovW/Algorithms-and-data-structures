package org.algorithmsAndDataStructures.matrix;
// https://leetcode.com/problems/number-of-islands/description/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if ((row < 0 || col < 0) || (row >= grid.length) || (col >= grid[0].length)) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        var ans = new NumberOfIslands();
        var grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println(ans.numIslands(grid));
    }
}
