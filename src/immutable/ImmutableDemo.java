package immutable;


public class ImmutableDemo {

    public static void main(String[] args) {

    }
}

final class Student implements Cloneable {

    private final String name;
    private final Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }
}