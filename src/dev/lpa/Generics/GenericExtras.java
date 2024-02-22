package dev.lpa.Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExtras {
    public static void main(String[] args) {
        int count = 10;
        List<StudentType> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new StudentType());
        }
        students.add(new StudentSubType());
        printList(students);

        List<StudentSubType> subStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            subStudents.add(new StudentSubType());
        }
        printList(subStudents);
    }

//    public static <T extends StudentType> void printList(List<T> students) {
//        for (T student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }

    public static void printList(List<? extends StudentType> students) {
        for (StudentType student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

//    public static void printList(List<? super StudentSubType> students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }
}
