package com.custodio.study.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchOnesInMatrix {

    @Test
    public void example1() {
        //given
        final var matrix = new int[][]{
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        //given
        final var matrix = new int[][]{
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 0, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        //given
        final var matrix = new int[][]{
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 0, 0, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        //given
        final var matrix = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        //given
        final var matrix = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void example6() {
        //given
        final var matrix = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void example7() {
        //given
        final var matrix = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        //when
        final var actual = solution(matrix);
        //then
        final var expected = 1;
        assertEquals(expected, actual);
    }

    private int solution(final int[][] matrix) {
        var count = 0;
        for (var row = 0; row < matrix.length; row++) {
            for (var column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1 && isIsland(row, column, matrix)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isIsland(final int row, final int column, final int[][] matrix) {
        if (row == matrix.length || row < 0 || column == matrix[row].length || column < 0 || matrix[row][column] == 0) {
            return false;
        }
        matrix[row][column] = 0;
        isIsland(row + 1, column, matrix);
        isIsland(row - 1, column, matrix);
        isIsland(row, column + 1, matrix);
        isIsland(row, column - 1, matrix);
        return true;
    }
}