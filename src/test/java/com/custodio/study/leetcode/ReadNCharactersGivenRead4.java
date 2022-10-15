package com.custodio.study.leetcode;

import org.junit.Test;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Leet Code</a>
 */
public class ReadNCharactersGivenRead4 {

    @Test
    public void example1() {
        //given
        //when
        //then
    }

    public int read(char[] buffer, int numberOfCharactersToRead) {
        var total = 0;
        var temporaryBuffer = new char[4];
        for(int characters = read4(temporaryBuffer); characters > 0; total = characters, characters = read4(temporaryBuffer)) {
            for(int sourceIndex = 0, destinationIndex = total; destinationIndex < characters; sourceIndex++, destinationIndex++) {
                buffer[destinationIndex] = temporaryBuffer[sourceIndex];
            }
        }
        return total;
    }

    int read4(char[] buf4) {
        return -1;
    }
}
