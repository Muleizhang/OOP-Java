package org.example;

public class StackOverflowError {
    public static void main(String[] args) {
        recursionFunction(0);
    }

    private static void recursionFunction(int depth) {
        System.out.println(depth);
        recursionFunction(depth + 1);
    }
}
