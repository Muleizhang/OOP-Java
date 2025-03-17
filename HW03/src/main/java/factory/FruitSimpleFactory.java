package factory;

// interface
interface Fruit {
    void use();
}

// A
class Apple implements Food {
    @Override
    public void use() {
        System.out.println("Apple");
    }
}

// B
class Banana implements Food {
    @Override
    public void use() {
        System.out.println("Banana");
    }
}

// 简单工厂类
class SimpleFactory {
    public static Food createProduct(String type) {
        if (type.equals("A")) {
            return new Apple();
        } else if (type.equals("B")) {
            return new Banana();
        } else {
            throw new IllegalArgumentException("Unknown product type");
        }
    }
}

public class FruitSimpleFactory {
    public static void main(String[] args) {
        Food fruitA = SimpleFactory.createProduct("A");
        fruitA.use();

        Food fruitB = SimpleFactory.createProduct("B");
        fruitB.use();
    }
}