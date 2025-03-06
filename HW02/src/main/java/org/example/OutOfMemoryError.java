package org.example;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {
    public static void main(String[] args){
        List<int[]> array = new ArrayList<>();
        for (;;){
            array.add(new int[10000]);
        }
    }
}
