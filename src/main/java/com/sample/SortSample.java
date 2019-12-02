package com.sample;

import java.util.*;

class Sorter implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() == o2.getCgpa()) {
            int result = o1.getFname().compareTo(o2.getFname());
            if (result == 0) {
                return o2.getId() > o1.getId() ? 1 : -1;
            }
            return result;
        } else {
            return o2.getCgpa() > o1.getCgpa() ? 1 : -1;
        }
    }
}

class Student {

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class SortSample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(new Sorter());
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
