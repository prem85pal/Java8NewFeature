package immutable;

/*
 * The instance variable of the class is final i.e.
 * we cannot change the value of it after creating an object.
 * The class is final so we cannot create the subclass.
 * There is no setter methods i.e. we have no option to change the value of the instance variable.
 * */

public class ImmutableDemo {

    public static void main(String[] args) {

        Student student = new Student("Prem");
        System.out.println(student.getName());

    }
}

final class Student implements Cloneable {

    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }
}