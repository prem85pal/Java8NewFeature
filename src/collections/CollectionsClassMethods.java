package collections;

import java.util.*;

public class CollectionsClassMethods {

    public static void main(String[] args) {

        LinkedList<StudentB> list = new LinkedList<StudentB>();
        list.add(new StudentB("A", -28));
        list.add(new StudentB("B", 20));
        list.add(new StudentB("C", -12));
        list.add(new StudentB("D", 8));
        Comparator<StudentB> cmp = Collections.reverseOrder(StudentB.AgeComparator);

        // Collections.sort(list, cmp);
        Collections.sort(list, StudentB.AgeComparator);

        Collections.sort(list, new Comparator<StudentB>() {
            @Override
            public int compare(StudentB s1, StudentB s2) {
                if (s1.age == s2.age)
                    return 0;
                else if (s1.age > s2.age)
                    return 1;
                else
                    return -1;
            }
        });

        //java8
        list.sort(new Comparator<StudentB>() {
            @Override
            public int compare(StudentB o1, StudentB o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //java 8 lambda
        list.sort((StudentB o1, StudentB o2) -> o1.getName().compareTo(o2.getName()));

        //java 8 lambda
        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        System.out.println("List sorted in ReverseOrder: ");
        for (StudentB studentB : list) {
            System.out.println(studentB + " ");
        }
    }
}

class StudentB {

    String name;
    int age;

    public static final Comparator<StudentB> AgeComparator = new Comparator<StudentB>() {
        @Override
        public int compare(StudentB s1, StudentB s2) {
            if (s1.age == s2.age)
                return 0;
            else if (s1.age > s2.age)
                return 1;
            else
                return -1;
        }
    };

    StudentB(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentB student = (StudentB) o;
        return age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {

        return 31 * (name != null ? name.hashCode() : 0) + age;
    }

    @Override
    public String toString() {
        return "StudentB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}