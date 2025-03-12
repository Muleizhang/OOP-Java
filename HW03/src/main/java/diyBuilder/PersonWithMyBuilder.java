package diyBuilder;

public class PersonWithMyBuilder {
    private String id;
    private int age;

    PersonWithMyBuilder(String id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "id:" + id + "\n" + "age:" + age;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String id;
        private int age;

        PersonBuilder() {
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public PersonBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonWithMyBuilder build() {
            return new PersonWithMyBuilder(this.id, this.age);
        }
    }
}
