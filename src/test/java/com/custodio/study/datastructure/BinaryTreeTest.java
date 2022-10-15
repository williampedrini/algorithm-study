package com.custodio.study.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

    @Test
    public void when_ThereAreTwoEqualsTree_Then_ReturnTrueForEquals() {
        //when
        final var binaryTree1 = BinaryTree.<Integer>builder()
                .add(1)
                .add(2)
                .build();
        final var binaryTree2 = BinaryTree.<Integer>builder()
                .add(1)
                .add(2)
                .build();
        //then
        assertEquals(binaryTree1, binaryTree2);
    }
}
