package com.custodio.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://leetcode.com/problems/buildings-with-an-ocean-view/">Leet Code</a>
 */
public class BuildingsWithAnOceanView {

    @Test
    public void example1() {
        //given
        final var input = new int[]{4, 2, 3, 1};
        //when
        final var actual = findBuildings(input);
        //then
        final var expected = new int[]{0, 2, 3};
        assertArrayEquals(expected, actual);
    }

    public int[] findBuildings(final int[] heights) {
        var maxHeight = 0;
        var buildingIndexes = new ArrayList<Integer>();
        for (var index = heights.length - 1; index >= 0; index--) {
            final var height = heights[index];
            if (height > maxHeight) {
                buildingIndexes.add(index);
            }
            maxHeight = Math.max(maxHeight, height);
        }
        return buildingIndexes
                .stream()
                .mapToInt(building -> building)
                .sorted()
                .toArray();
    }
}
