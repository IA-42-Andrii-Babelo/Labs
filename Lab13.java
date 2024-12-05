package org.example;

import java.util.*;

public class Lab13 {
    public static void main(String[] args) {
        try {
            Institute KPI = new Institute("KPI");

            Faculty Fiot = new Faculty("Fiot", 2);
            Faculty Ipsa = new Faculty("Ipsa", 3);

            try {

                Fiot.addStudent(new Student("LizA", "Hutryk", "Ak812", 100));
                Fiot.addStudent(new Student("Diana", "Hutryk", "Ak813", 95));
                Ipsa.addStudent(new Student("Andrii", "Hutryk", "Ak814", 90));
                Fiot.addStudent(new Student("Zelenskii", "Hutryk", "Ak818", 93));


            }
            catch (MaxStudentsExceededException e) {

                System.out.println("Помилка: " + e.getMessage());
            }

            KPI.addFaculty(Ipsa);
            KPI.addFaculty(Fiot);


            System.out.println("Загальна кількість студентів в інституті: " + KPI.getAmountOfStudentsOfInstitute());
            System.out.println("Найбільший факультет: " + KPI.getBiggestFaculty().getName());

            Set<Student> coolGuys = KPI.getCoolestStudents();
            for (Student student : coolGuys) {
                System.out.println("Крутий студент: " + student.getName());
            }

            try {
                Student s = KPI.findStudentByRecordBook("Ak813");
                System.out.println("Знайдений студент: " + s.getName());
            }
            catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }

            try {
                Faculty nullFaculty = null;
                nullFaculty.getName();
            } catch (NullPointerException e) {
                System.out.println("Помилка, null об'єкт");
            }

            try {
                KPI.findStudentByRecordBook(null);
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: номер залікової книги не може бути null");
            }

        } finally {
            System.out.println("Кінець ;)");
        }
    }
}


class MaxStudentsExceededException extends Exception {
    public MaxStudentsExceededException(String message) {
        super(message);
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
    private int maxStudents;

    public Faculty(String name, int maxStudents) {
        this.name = name;
        this.students = new HashSet<>();
        this.maxStudents = maxStudents;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) throws MaxStudentsExceededException {
        if (students.size() >= maxStudents) {
            throw new MaxStudentsExceededException("Факультет " + name + " досяг максимальної кількості студентів (" + maxStudents + ").");
        }
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
        if (recordBookNumber == null) {
            throw new IllegalArgumentException("Номер залікової книги не може бути null.");
        }
        return studentMap.get(recordBookNumber);
    }
}
