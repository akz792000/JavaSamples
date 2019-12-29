package com.hacker.rank;

import java.util.*;

/*
--input--
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED

--output--
Dan
Ashley
Shafaet
Maria
*/

class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pQueue = new PriorityQueue<>(
                Comparator.comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId));

        for (String item : events) {
            if (item.equals("SERVED")) {
                if (!pQueue.isEmpty()) {
                    pQueue.remove();
                }
            } else {
                String[] values = item.split(" ");
                String name = values[1];
                Double cgpa = Double.valueOf(values[2]);
                Integer id = Integer.valueOf(values[3]);
                pQueue.add(new Student(id, name, cgpa));
            }
        }

        // it does not give base on the default order
        // return pQueue.stream().collect(Collectors.toCollection(ArrayList::new));

        List<Student> result = new ArrayList<>();
        while (!pQueue.isEmpty()) {
            result.add(pQueue.poll());
        }
        return result;
    }

}

public class PriorityQueueSample {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
