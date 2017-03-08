package com.e16.training.iterator;


import java.util.NoSuchElementException;

public class SimpleIterable<T> {
    private final T[] items;

    public SimpleIterable(final T[] items) {
        this.items = items;
    }

    public int size() {
        return items.length;
    }

    public Iterator<T> getIterator() {
        return new SimpleIterator();
    }

    class SimpleIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            if (index < size()) {
                return true;
            }

            return false;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return items[index++];
            }
            throw new NoSuchElementException("");
        }
    }
}
