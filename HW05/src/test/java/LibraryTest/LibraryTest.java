package LibraryTest;

import Item.*;

// 测试类 LibraryTest
class LibraryTest {
    public static void processItem(Item item) {
        item.borrow();  // 调用多态方法
        item.getItemDetails();  // 调用协变返回类型方法
        item.returnItem();

        if (item instanceof Reservable) {
            ((Reservable) item).reserve();
        }

        // 显示物品标识符
        System.out.println(item.getIdentifier());
    }

    public static void main(String[] args) {
        // 创建 Book 对象
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");

        // 创建 Magazine 对象
        Magazine magazine = new Magazine("National Geographic", "2022-09", "September 2022");

        System.out.println("\nProcessing Book:");
        processItem(book);  // 处理 Book 对象

        System.out.println("\nProcessing Magazine:");
        processItem(magazine);  // 处理 Magazine 对象

        // 测试 final 方法效果
        System.out.println("\nIdentifier of the book: " + book.getIdentifier());
        System.out.println("Identifier of the magazine: " + magazine.getIdentifier());
    }
}