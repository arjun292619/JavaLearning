package dev.lpa.Generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Comparing {
    public static void main(String[] args) {
        String banana = "banana";
        String[] words = new String[]{"apple", "banana", "pear", "BANANA"};

        for (String s : words) {
            int val = s.compareTo(banana);
//            int val = banana.compareTo(s);
            System.out.printf("%s %s %s %n", s, banana, val);
        }

        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        System.out.println("A: " + (int) 'A' + " a: " + (int) 'a');
        System.out.println("B: " + (int) 'B' + " b: " + (int) 'b');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Michelle"), new Student("Obama"), new Student("Dexter")};
//        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentGpaComparator().reversed());
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student> {
    private static int LAST_ID = 1000;
    protected static Random random = new Random();
    protected String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s(%4.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(id, o.id);
    }
}

class StudentGpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}
