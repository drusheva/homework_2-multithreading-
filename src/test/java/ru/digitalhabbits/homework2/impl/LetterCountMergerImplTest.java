package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class LetterCountMergerImplTest {

    @Test
    public void when_send_String_to_count_Then_return_map() {
        //given
        var merger = new LetterCountMergerImpl();
        var map1 = new HashMap<Character, Long>();
        map1.put('a', 2L);
        map1.put('b', 2L);
        map1.put('c', 3L);
        map1.put('d', 3L);
        map1.put('e', 4L);
        map1.put('f', 2L);
        var map2 = new HashMap<Character, Long>();
        map2.put('a', 3L);
        map2.put('b', 11L);
        map2.put('c', 1L);
        map2.put('e', 4L);
        map2.put('f', 2L);
        map2.put('j', 2L);
        var expected = new HashMap<Character, Long>();
        expected.put('a', 5L);
        expected.put('b', 13L);
        expected.put('c', 4L);
        expected.put('d', 3L);
        expected.put('e', 8L);
        expected.put('f', 4L);
        expected.put('j', 2L);
        //when
        var actual = merger.merge(map1, map2);
        //then
        assertEquals(expected, actual);
    }

}