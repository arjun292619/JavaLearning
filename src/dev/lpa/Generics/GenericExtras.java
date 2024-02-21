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
        printList(students);

        List<StudentSubType> subStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            subStudents.add(new StudentSubType());
        }
        printList(subStudents);
    }

    public static void printList(List<StudentType> students) {
        for (StudentType student : students) {
            System.out.println(student);
        }
    }
}
