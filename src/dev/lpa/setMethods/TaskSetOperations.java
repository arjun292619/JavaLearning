package dev.lpa.setMethods;

import java.util.*;

public class TaskSetOperations {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("All");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPrioriy = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Anns Tasks", annsTasks, sortByPrioriy);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");

        List<Set<Task>> sets = new ArrayList<>(List.of(annsTasks,bobsTasks,carolsTasks));
        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks,assignedTasks));
        sortAndPrint("Master List of all Tasks",everyTask);

        Set<Task> missingFromMaster = getDifference(everyTask,tasks);
        sortAndPrint("Missiong Tasks from Manager List",missingFromMaster);

        Set<Task> unassignedTasks = getDifference(everyTask,assignedTasks);
        sortAndPrint("Unassigned Task List", unassignedTasks,sortByPrioriy);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks,bobsTasks),
                getIntersect(bobsTasks,carolsTasks),
                getIntersect(annsTasks,carolsTasks)
                )
        );

        sortAndPrint("Assigned to multiples", overlap,sortByPrioriy);

        List<Task> overlapping = new ArrayList<>();
        for(Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set,overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = Comparator.comparing(Task::getPriority).thenComparing(Comparator.naturalOrder());
        sortAndPrint("Overlapping Duplicate Tasks", overlapping,priorityNatural);
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

    private static Set<Task> getUnion(List<Set<Task>> tasksets) {
        Set<Task> unionAll = new HashSet<>();
        tasksets.forEach(unionAll::addAll);
        return unionAll;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);
        return difference;
    }
}
