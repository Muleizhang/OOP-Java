package org.task1;

import java.util.Objects;

public class MyBox<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public boolean equals(MyBox<?> other) {
        if (this == other || (this.item == null && other.item == null)) return true;
        if (other == null || this.item == null || other.item == null) return false;
        return Objects.equals(item, other.item);
    }
}

