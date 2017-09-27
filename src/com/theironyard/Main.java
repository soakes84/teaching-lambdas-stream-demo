package com.theironyard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    List<Student> studentList = buildStudentList();

    for(Student stud : studentList) {    //un-ordered list
        System.out.println(stud);
    }
        System.out.println();         //print empty line just to separate

    studentList.sort(new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {                    //anonymous class
            if(o1.getGradePercentage() > (o2.getGradePercentage())) {
                return 1;
            } else if (o2.getGradePercentage() > o1.getGradePercentage()){
                return -1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    });

    for(Student stud : studentList) {      //ordered list by GPA lowest to highest
        System.out.println(stud);
    }

    studentList.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));   //lambda

        System.out.println();                       //just to print empty line to separate

        for(Student stud : studentList) {
            System.out.println(stud);               //ordered list by Name
        }

        System.out.println();

        List<Student> streamStuds = buildStudentList();    //streaming going on

        streamStuds.stream()
                .filter((s) -> s.getGradePercentage() >= 3.3)
                        .forEach(s -> System.out.println("\t" + s.getName()));

        System.out.println();

        System.out.println("The Top Students GPA sum'd up!");
        double sumOfTopStuds = streamStuds.stream()
                .filter(s -> s.getGradePercentage() > 3.4)
                .mapToDouble(s -> s.getGradePercentage())    //mapping here
                .sum();
        System.out.println(sumOfTopStuds);


    }

    public static List buildStudentList () {
        List<Student> students = new ArrayList<>();

        students.add(new Student(3.7, "Chloe", "Java", "Junior"));
        students.add(new Student(3.5, "Bob", "Java", "Senior"));
        students.add(new Student(3.9, "Kathy", "Java", "Junior"));
        students.add(new Student(3.0, "Willie", "Java", "Freshman"));
        students.add(new Student(2.6, "Tom", "JavaScript", "Junior"));
        students.add(new Student(3.8, "Brit", "C#", "Senior"));
        students.add(new Student(3.2, "Mary", "Everything", "Freshman"));
        students.add(new Student(1.1, "That Guy", "Nothing", "Sophomore"));
        students.add(new Student(4.0, "Kristie", "Java", "Junior"));

        return students;
    }

}
