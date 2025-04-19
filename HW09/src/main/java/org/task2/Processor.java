package org.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Processor<T> {
    void process(T item);

}

class StringPrinter implements Processor<String> {

    @Override
    public void process(String item) {
        System.out.println(item);
    }
}

class NumberSummer implements Processor<Integer> {
    @Override
    public void process(Integer item) {
        int sum = 0;
        while (item > 0) {
            sum += item % 10;
            item /= 10;
        }
        System.out.println(sum);
    }
}

class ProcessorUtil {
    public static <T> void apply(List<? extends T> list, Processor<T> processor) {
        list.forEach(processor::process);
    }

    public static <T> void collect(List<? super T> dest, List<T> src) {
        dest.addAll(src);
    }
}

class TestProcessor {
    public static void main(String[] args) {
        List<String> listString = Arrays.asList("a", "b", "c");
        ProcessorUtil.apply(listString, new StringPrinter());
        System.out.println();

        List<Integer> listNumber = Arrays.asList(114, 514, 520, 711);
        ProcessorUtil.apply(listNumber, new NumberSummer());
        System.out.println();


        List<Number> listNumber2 = new ArrayList<>();
        listNumber2.add(3.14);
        ProcessorUtil.collect(listNumber2, listNumber);
        System.out.println(listNumber2);
    }
}