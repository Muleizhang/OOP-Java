package lombokBuilder;

import lombok.Builder;

@Builder
public class Person {
    private String id;
    private int age;

    @Override
    public String toString() {
        return "id:" + id + "\n" + "age:" + age;
    }
}


