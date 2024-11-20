package org.example;


import java.util.*;

public class TreeSetu {
    public static void main(String[] args) {
        Institute KPI = new Institute("KPI");

        Faculty Fiot = new Faculty("Fiot");
        KPI.addFaculty(Fiot);

        Faculty Ipsa = new Faculty("Ipsa");
        KPI.addFaculty(Ipsa);

        Fiot.addStudent(new Student("LizA", "Hutryk", "Ak812", 100));
        Fiot.addStudent(new Student("Diana", "Hutryk", "Ak813", 95));
        Ipsa.addStudent(new Student("Andrii", "Hutryk", "Ak815", 90));

        System.out.println(KPI.getAmountOfStudentsOfInstitute());
        System.out.println(KPI.getBiggestFaculty().getName());

        Set<Student> coolGuys = KPI.getCoolestStudents();
        for (Student student : coolGuys) {
            System.out.println(student.getName());
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private String lastname;
    private String recordBookNumber;
    private double averageGrade;

    public Student(String name, String lastname, String recordBookNumber, double averageGrade) {
        this.name = name;
        this.lastname = lastname;
        this.recordBookNumber = recordBookNumber;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.averageGrade, other.averageGrade);
    }
}


class Faculty {
    private String name;
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getAmountOfStudents() {
        return students.size();
    }

    public Set<Student> getStudents() {
        return students;
    }
}


class Institute {
    private String name;
    private Set<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new TreeSet<>(Comparator.comparing(Faculty::getName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void deleteFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public int getAmountOfStudentsOfInstitute() {
        int total = 0;
        for (Faculty faculty : faculties) {
            total += faculty.getAmountOfStudents();
        }
        return total;
    }

    public Faculty getBiggestFaculty() {
        return faculties.stream()
                .max(Comparator.comparing(Faculty::getAmountOfStudents))
                .orElse(null);
    }

    public Set<Student> getCoolestStudents() {
        Set<Student> coolestStudents = new TreeSet<>(Comparator.comparing(Student::getName));
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getAverageGrade() >= 95 && student.getAverageGrade() <= 100) {
                    coolestStudents.add(student);
                }
            }
        }
        return coolestStudents;
    }
}