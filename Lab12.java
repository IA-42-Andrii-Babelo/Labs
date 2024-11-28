package org.example;

import java.util.*;

public class Lab12 {
    public static void main(String[] args) {
        Institute KPI = new Institute("KPI");


        Faculty Fiot = new Faculty("Fiot");
        KPI.addFaculty(Fiot);
        Faculty Ipsa = new Faculty("Ipsa");
        KPI.addFaculty(Ipsa);

        Fiot.addStudent(new Student("LizA", "Hutryk", "Ak812", 100));
        Fiot.addStudent(new Student("Diana", "Hutryk", "Ak813", 95));
        Ipsa.addStudent(new Student("Andrii", "Hutryk", "Ak815", 90));

        KPI.addFaculty(Fiot);
        KPI.addFaculty(Ipsa);


        System.out.println(KPI.getAmountOfStudentsOfInstitute());
        System.out.println(KPI.getBiggestFaculty().getName());
        Set<Student> coolguys = KPI.getCoolestStudents();
        for (Student student : coolguys) {
            System.out.println(student.getName());
        }

        Student s = KPI.findStudentByRecordBook("Ak815");
        System.out.println(s.getName());
    }
}

class Student {
    private String name;
    private String lastname;
    private String recordBookNumber;
    public double averageGrade;

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

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordBookNumber);
    }
}

class Faculty {
    private String name;
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>();
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
    private Map<String, Student> studentMap;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
        this.studentMap = new HashMap<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);

        for (Student student : faculty.getStudents()) {
            studentMap.put(student.getRecordBookNumber(), student);
        }

    }

    public void deleteFaculty(Faculty faculty) {
        faculties.remove(faculty);

        for (Student student : faculty.getStudents()) {
            studentMap.remove(student.getRecordBookNumber());

        }
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
        Faculty biggest = null;
        int max = 0;

        for (Faculty faculty : faculties) {
            if (faculty.getAmountOfStudents() > max) {
                max = faculty.getAmountOfStudents();
                biggest = faculty;
            }
        }

        return biggest;
    }

    public Set<Student> getCoolestStudents() {

        Set<Student> coolestStudents = new HashSet<>();
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.averageGrade >= 95 && student.averageGrade <= 100) {
                    coolestStudents.add(student);

                }
            }
        }

        return coolestStudents;
    }

    public Student findStudentByRecordBook(String recordBookNumber) {
        return studentMap.get(recordBookNumber);
    }
}

