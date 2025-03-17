package dynamicArray;


public class DynamicArray {
    private int size;
    private int[] array;

    DynamicArray() {
        size = 0;
        array = new int[10];
    }

    DynamicArray(int initialCapacity) {
        size = 0;
        array = new int[initialCapacity];
    }

    void add(int item) {
        if (size == array.length) {
            int[] new_array = new int[size * 2]; // 二倍扩容
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
        }
        array[size++] = item;
    }


    int size() {
        return size;
    }

    void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
    }

    int get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    int capacity() {
        return array.length;
    }

    void resize(int newSize) {
        if (newSize > capacity()) {
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        } else if (newSize < size) {
            size = newSize; // 只保留前newSize个元素
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}