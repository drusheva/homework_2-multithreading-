package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LetterCounterImplTest {

    @Test
    public void when_send_String_to_count_Then_return_map() {
        //given
        String testString = "cdccfdbfeadebaee";
        var letterCounter = new LetterCounterImpl();
        var expected = new HashMap<Character, Long>();
        expected.put('a', 2L);
        expected.put('b', 2L);
        expected.put('c', 3L);
        expected.put('d', 3L);
        expected.put('e', 4L);
        expected.put('f', 2L);
        //when
        var actual = letterCounter.count(testString);
        //then
        assertEquals(expected, actual);
    }

}