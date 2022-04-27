package ru.digitalhabbits.homework2.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReader;
import ru.digitalhabbits.homework2.LetterCountMerger;
import ru.digitalhabbits.homework2.LetterCounter;

@RequiredArgsConstructor
public class AsyncFileLetterCounter implements FileLetterCounter {

    private final FileReader fileReader;
    private final LetterCounter letterCounter;
    private final LetterCountMerger letterCountMerger;

    @Override
    @SneakyThrows
    public Map<Character, Long> count(File input) {
        //todo

        return fileReader.readLines(input)
                .map(it -> CompletableFuture.supplyAsync(
                        () -> letterCounter.count(it)
                ))
                .map(CompletableFuture::join)
        .reduce(letterCountMerger::merge)
        .orElseGet(() -> new HashMap<Character,Long>());

    }
}
