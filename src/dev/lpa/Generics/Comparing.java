package dev.lpa.Generics;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }
}

class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
