package dynamicArray;

public class DynamicArrayTest {
    static void printDynamicArray(DynamicArray array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    static void case_1() {
        // 创建DynamicArray实例
        DynamicArray dynamicArray = new DynamicArray();

        // 添加元素
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        System.out.println("After adding elements: ");
        printDynamicArray(dynamicArray);

        // 删除元素
        dynamicArray.remove(1); // 删除索引为1的元素，即元素2
        System.out.println("After removing element at index 1: ");
        printDynamicArray(dynamicArray);

        // 再次添加元素，观察动态扩容
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println("After adding more elements: ");
        printDynamicArray(dynamicArray);

        // 获取并打印特定索引的元素
        System.out.println("Element at index 2: " + dynamicArray.get(2));

        // 打印当前数组的大小和容量
        System.out.println("Size: " + dynamicArray.size());
        System.out.println("Capacity: " + dynamicArray.capacity());
    }

    static void case_2() {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 0; i < 50; i++) {
            dynamicArray.add(i);
        }
        printDynamicArray(dynamicArray);
        System.out.println("Size: " + dynamicArray.size());
        System.out.println("Capacity: " + dynamicArray.capacity());

        for (int i = 0; i < 20; i++) {
            dynamicArray.remove(20);
        }
        printDynamicArray(dynamicArray);
        System.out.println("Size: " + dynamicArray.size());
        System.out.println("Capacity: " + dynamicArray.capacity());

        dynamicArray.resize(10);
        printDynamicArray(dynamicArray);
        System.out.println("Size: " + dynamicArray.size());
        System.out.println("Capacity: " + dynamicArray.capacity());

        dynamicArray.resize(5);
        printDynamicArray(dynamicArray);
        System.out.println("Size: " + dynamicArray.size());
        System.out.println("Capacity: " + dynamicArray.capacity());
    }

    static void case_3() {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 0; i < 50; i++) {
            dynamicArray.add(i);
        }
        System.out.println(dynamicArray.get(49));
        try {
            System.out.println(dynamicArray.get(50));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        System.out.println("-----case_1:-----");
        case_1();
        System.out.println("-----case_2:-----");
        case_2();
        System.out.println("-----case_3:-----");
        case_3();
    }
}
