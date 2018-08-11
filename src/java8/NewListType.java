package java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewListType {

    public static void main(String[] args) {
        List<StudentDTO> list = listOfStudent().stream().map(StudentDTO::new).collect(Collectors.toList());
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
    }

    private static List<Student> listOfStudent() {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "s1"));
        list.add(new Student(2, "s2"));
        list.add(new Student(3, "s3"));
        list.add(new Student(4, "s4"));
        list.add(new Student(5, "s5"));
        return list;
    }
}
