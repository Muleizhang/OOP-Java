package dynamicArray;

import java.util.ArrayList;

public class DynamicArrayBench {
    public static void main(String[] args) {
        {
            long before = System.currentTimeMillis();
            var a = new DynamicArray();
            for (int i = 0; i < 100000000; i++) {
                a.add(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("DynamicArray without init time cost: " + (after - before));
        }

        {
            long before = System.currentTimeMillis();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < 100000000; i++) {
                a.add(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("ArrayList without init time cost: " + (after - before));
        }
        {
            long before = System.currentTimeMillis();
            var a = new DynamicArray(100000000);
            for (int i = 0; i < 100000000; i++) {
                a.add(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("DynamicArray without init time cost: " + (after - before));
        }

        {
            long before = System.currentTimeMillis();
            ArrayList<Integer> a = new ArrayList<>(100000000);
            for (int i = 0; i < 100000000; i++) {
                a.add(i);
            }
            long after = System.currentTimeMillis();
            System.out.println("ArrayList with init time cost: " + (after - before));
        }
    }
}
