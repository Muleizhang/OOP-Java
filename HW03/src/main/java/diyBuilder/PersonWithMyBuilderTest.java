package diyBuilder;

public class PersonWithMyBuilderTest {
    public static void main(String[] args) {
        PersonWithMyBuilder p1 = PersonWithMyBuilder.builder().id("Bob").age(20).build();
        System.out.println(p1);
    }
}
