**简单工厂模式** 和 **工厂方法模式** 是两种常见的设计模式，都属于创建型模式，用于解耦对象的创建过程。它们的主要目的是将对象的实例化过程与使用过程分离，从而提高代码的灵活性和可维护性。

---

### 1. **简单工厂模式（Simple Factory Pattern）**

#### 定义：

简单工厂模式通过一个工厂类来创建对象，客户端不需要直接实例化具体类，而是通过工厂类来获取所需的对象。

#### 结构：

- **工厂类（Factory）**：负责创建对象的类，通常包含一个静态方法，根据输入参数决定创建哪种对象。
- **抽象产品类（Product）**：定义产品的接口或抽象类。
- **具体产品类（Concrete Product）**：实现抽象产品类的具体类。

#### 示例代码：

```java
// 抽象产品
interface Product {
    void use();
}

// 具体产品A
class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// 具体产品B
class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// 简单工厂
class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        }
        throw new IllegalArgumentException("Unknown product type");
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.use(); // 输出: Using Product A
    }
}
```

#### 优势：

- **简单易用**：客户端不需要知道具体产品的创建细节，只需要通过工厂类获取对象。
- **解耦**：将对象的创建过程与使用过程分离，降低了客户端与具体产品类之间的耦合。

#### 劣势：

- **违反开闭原则**：如果需要添加新的产品类型，必须修改工厂类的代码，扩展性较差。
- **工厂类职责过重**：工厂类负责所有产品的创建逻辑，可能会导致工厂类过于复杂。

---

### 2. **工厂方法模式（Factory Method Pattern）**

#### 定义：

工厂方法模式定义了一个创建对象的接口，但由子类决定实例化哪个类。工厂方法模式将对象的创建延迟到子类。

#### 结构：

- **抽象工厂类（Creator）**：定义工厂方法的接口。
- **具体工厂类（Concrete Creator）**：实现工厂方法，负责创建具体产品。
- **抽象产品类（Product）**：定义产品的接口或抽象类。
- **具体产品类（Concrete Product）**：实现抽象产品类的具体类。

#### 示例代码：

```java
// 抽象产品
interface Product {
    void use();
}

// 具体产品A
class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// 具体产品B
class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// 抽象工厂
abstract class Factory {
    public abstract Product createProduct();

    public void useProduct() {
        Product product = createProduct();
        product.use();
    }
}

// 具体工厂A
class FactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

// 具体工厂B
class FactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

// 客户端
public class Client {
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        factory.useProduct(); // 输出: Using Product A

        factory = new FactoryB();
        factory.useProduct(); // 输出: Using Product B
    }
}
```

#### 优势：

- **符合开闭原则**：新增产品时，只需要添加新的工厂类和产品类，无需修改现有代码。
- **解耦**：客户端只依赖于抽象工厂和抽象产品，与具体实现解耦。
- **扩展性强**：适合需要频繁扩展产品类型的场景。

#### 劣势：

- **类的数量增加**：每新增一个产品，都需要新增一个工厂类，可能会导致类的数量过多。
- **复杂度较高**：相比于简单工厂模式，工厂方法模式的结构更复杂。

---

### 3. **简单工厂模式 vs 工厂方法模式**

| 特性       | 简单工厂模式          | 工厂方法模式           |
|----------|-----------------|------------------|
| **定义**   | 一个工厂类负责创建所有产品   | 每个产品对应一个工厂类      |
| **扩展性**  | 较差，新增产品需要修改工厂类  | 较好，新增产品只需新增工厂类   |
| **复杂度**  | 简单              | 较复杂              |
| **适用场景** | 产品类型较少且不频繁变化的场景 | 产品类型较多且可能频繁扩展的场景 |
| **开闭原则** | 违反开闭原则          | 符合开闭原则           |

---

### 4. **总结**

- **简单工厂模式**：适合产品类型较少、变化不频繁的场景，优点是简单易用，缺点是扩展性差。
- **工厂方法模式**：适合产品类型较多、可能频繁扩展的场景，优点是扩展性强，缺点是类的数量较多。

根据实际需求选择合适的模式，如果产品类型固定且简单，可以使用简单工厂模式；如果需要灵活扩展，建议使用工厂方法模式。