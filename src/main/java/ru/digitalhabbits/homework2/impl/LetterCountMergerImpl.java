package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCountMerger;

import java.util.Map;

public class LetterCountMergerImpl implements LetterCountMerger {

    @Override
    public Map<Character, Long> merge(Map<Character, Long> first, Map<Character, Long> second) {

        first.forEach((k, v) -> second.merge(k, v, Long::sum));
        return second;
    }
}
