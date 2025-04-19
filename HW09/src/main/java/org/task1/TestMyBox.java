package org.task1;

public class TestMyBox {
    public static void main(String[] args) {
        MyBox<String> str = new MyBox<>();
        str.set("item");
        System.out.println(str);

        MyBox<Integer> i = new MyBox<>();
        i.set(114514);
        System.out.println(i);

        MyBox<Double> dou = new MyBox<>();
        dou.set(3.14);
        System.out.println(dou);
    }
}
