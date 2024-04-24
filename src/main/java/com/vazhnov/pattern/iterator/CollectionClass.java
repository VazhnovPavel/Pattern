package com.vazhnov.pattern.iterator;

import com.vazhnov.pattern.iterator.MyIterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class CollectionClass implements MyIterator {

    @Override
    public boolean tryAdvance(Consumer action) {
        return false;
    }

    @Override
    public Spliterator trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
