package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @see <a href='https://leetcode.com/problems/merge-sorted-array/'>Leet Code</a>
 */
public class NumberOfIslands {

    @Test
    public void example1() {
        //given'
        final var input = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        //when
        final var actual = numIslands(input);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given'
        final var input = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        //when
        final var actual = numIslands(input);
        //then
        final var expected = 3;
        assertEquals(expected, actual);
    }

    public int numIslands(final char[][] grid) {
        var counter = 0;
        for (var row = 0; row < grid.length; row++) {
            for (var column = 0; column < grid[row].length; column++) {
                final var currentValue = grid[row][column] - '0';
                if (currentValue == 1) {
                    markIsland(grid, row, column);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void markIsland(final char[][] grid, final int row, final int column) {
        if (row == grid.length || row < 0 || column == grid[row].length || column < 0 || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        markIsland(grid, row + 1, column);
        markIsland(grid, row - 1, column);
        markIsland(grid, row, column + 1);
        markIsland(grid, row, column - 1);
    }
}
