package java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListIteration {


    public static void main(String[] args) {

        Student student1 = new Student(1, "S1");
        Student student2 = new Student(2, "S2");
        Student student3 = new Student(3, "S3");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println(studentList.stream().map(ListIteration::m1).collect(Collectors.toList()));

        System.out.println(studentList);

    }

    public static List<StudentDTO> m1(Student student) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());


        List<StudentDTO> list = new ArrayList<>();
        list.add(studentDTO);
        return list;

    }


}
