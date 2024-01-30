package dev.lpa.setMethods;

import java.util.*;

public class TaskSetOperations {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("All");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPrioriy = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Anns Tasks",annsTasks, sortByPrioriy);
    }

    private static void sortAndPrint(String header, Collection<Task> taskCollection) {
        sortAndPrint(header, taskCollection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> taskCollection, Comparator<Task> taskComparator) {
        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(taskCollection);
        list.sort(taskComparator);
        list.forEach(System.out::println);
    }
}
