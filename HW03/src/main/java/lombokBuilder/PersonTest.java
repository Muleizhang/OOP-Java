package lombokBuilder;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = Person.builder().id("Bob").age(20).build();
        System.out.println(p1);
    }
}
