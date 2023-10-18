package org.kevin.ALGORITHM.UnionSet;

import org.junit.Test;

/**
 * @author Kevin.Zng
 * @date 2022/3/10 22:21
 */
public class CountIsland {

    @Test
    public void q() {
        char[][] n = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int count = numIslands(n);
        System.out.println(count);
    }

    private int violence(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int j = 0;
            while (i < grid.length && j < grid[i].length && grid[i][j] == '1') {
                j++;
            }

            for (int k = 0; k < j && i < grid.length; k++) {

            }


        }

        return -1;
    }

    public int numIslands(char[][] grid) {

        return -1;
    }
}
