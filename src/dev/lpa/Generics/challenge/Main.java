package dev.lpa.Generics.challenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryList<StudentSubType> subTypes = new QueryList<>();
        int counter = 30;
        for (int i = 0; i < counter; i++) {
            subTypes.add(new StudentSubType());
        }

        subTypes.sort(null);
        printList(subTypes);
        System.out.println("Filtering Data");

        QueryList<StudentSubType> matches = subTypes.getMatches("percentCompleted", "50").
                getMatches("course", "Java");
        printList(matches);
        matches.sort(new StudentSubType.PercentComparator());
        System.out.println("Sorting Filtered Data by Percent");
        printList(matches);
    }

    public static void printList(List<? extends StudentType> students) {
        for (StudentType student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
