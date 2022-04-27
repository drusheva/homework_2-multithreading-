package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCounter;

import java.util.HashMap;
import java.util.Map;

public class LetterCounterImpl implements LetterCounter {

    @Override
    public Map<Character, Long> count(String input) {
        Map<Character, Long> count = new HashMap<>();

        for (int i = 0; i < input.length( ); i++ ) {
            if (count.containsKey(input.charAt(i))) {
                var newValue = count.get(input.charAt(i));
                count.put(input.charAt(i), newValue + 1);
            } else {
                count.put(input.charAt(i), 1L);
            }
        }

        return count;
    }
}
