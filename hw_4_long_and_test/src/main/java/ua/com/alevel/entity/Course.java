package ua.com.alevel.entity;

import java.util.Arrays;

public class Course {


    private String id;
    private String courseName;
    private Student[] students;

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "HomeWork{" +
                "Id='" + getId() + +'\'' +
                "subject='" + courseName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
