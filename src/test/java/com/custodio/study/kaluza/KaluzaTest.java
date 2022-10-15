package com.custodio.study.kaluza;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class KaluzaTest {

    @Test
    public void test() {
        //given
        final var items = asList("orange", "apple", "pear", "blueberry");
        final var number = 5;
        //when
        final var actual = takeItemsFromListByDefinedAmount(items, number);
        //then
        final var expected = asList("orange", "apple", "pear", "blueberry", "orange");
        assertEquals(expected, actual);
    }

    private Collection<String> takeItemsFromListByDefinedAmount(final List<String> items, final int number) {
        var result = new ArrayList<String>(number);
        for (int index = 0, index2 = 0; index < number; index++, index2++) {
            if (index2 == items.size()) {
                index2 = 0;
            }
            final var item = items.get(index2);
            result.add(item);
        }
        return result;
    }
}
