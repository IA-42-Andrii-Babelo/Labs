package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class Collections {
    public static void main(String[] args) {
    Institute KPI = new Institute("KPI");


    Faculty Fiot = new Faculty("Fiot");

    KPI.addFaculty(Fiot);
    Faculty Ipsa = new Faculty("Ipsal");
    KPI.addFaculty(Ipsa);

    Fiot.addStudent(new Student("LizA", "Hutryk", "Ak812", 90 ));
    Fiot.addStudent(new Student("Diana", "Hutryk", "Ak813", 95 ));
    Ipsa.addStudent(new Student("Andrii", "Hutryk", "Ak815", 100 ));

        System.out.println(KPI.getAmountOfStudentsOnInstitute());
        System.out.println(KPI.getBiggestFaculty().getName());
        List<Student> coolguys = KPI.getCoolestStudents();
        for (Student student : coolguys) {
            System.out.println(student.getName());
        }

    }

}

class Student{
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
}


class Faculty{
private String name;
private ArrayList<Student> students;

public Faculty(String name){
    this.name = name;
    this.students = new ArrayList<>();
}

public String getName() {
    return name;
}

public void addStudent(Student student){
    students.add(student);
}

public void removeStudent(Student student){
    students.remove(student);
}

public int getAmountOfStudents(){
    return students.size();
}

public List<Student> getStudents(){
    return students;
}


}

class Institute {
private String name;
private ArrayList<Faculty> faculties;

public Institute(String name) {
    this.name = name;
    this.faculties = new ArrayList<>();
}

public void addFaculty(Faculty faculty) {
    faculties.add(faculty);
}
public void deleteFaculty(Faculty faculty) {
    faculties.remove(faculty);
}
public ArrayList<Faculty> getFaculties() {
    return faculties;
}

    public int getAmountOfStudentsOnInstitute(){
        int total = 0;
        for (Faculty faculty : faculties) {
            total += faculty.getAmountOfStudents();
        }

        return total;
    }

    public Faculty getBiggestFaculty(){
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

    public List<Student> getCoolestStudents(){
    List<Student> coolestStudents = new ArrayList<>();
    for (Faculty faculty : faculties) {
        Iterator studIterator = faculty.getStudents().iterator();
        while (studIterator.hasNext()) {
            Student student = (Student) studIterator.next();
            if (student.averageGrade >= 95 && student.averageGrade <= 100) {
                coolestStudents.add(student);
            }
        }
         }
        return coolestStudents;
    }


}



