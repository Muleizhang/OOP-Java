package factory;

interface Food {
    void use();
}

class Rice implements Food {
    @Override
    public void use() {
        System.out.println("Using Food A");
    }
}

class Noodle implements Food {
    @Override
    public void use() {
        System.out.println("Using Food B");
    }
}

interface Factory {
    Food createProduct();
}

class FactoryRice implements Factory {
    @Override
    public Food createProduct() {
        return new Rice();
    }
}

class FactoryNoodle implements Factory {
    @Override
    public Food createProduct() {
        return new Noodle();
    }
}

public class FoodFactoryMethod {
    public static void main(String[] args) {
        Factory factoryA = new FactoryRice();
        Food productA = factoryA.createProduct();
        productA.use();  // 输出: Using Food A

        Factory factoryB = new FactoryNoodle();
        Food productB = factoryB.createProduct();
        productB.use();  // 输出: Using Food B
    }
}