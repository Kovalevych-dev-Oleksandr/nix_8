package ua.com.alevel.entity;

import java.util.Arrays;

public class Student extends BaseEntity {
    private String name;
    private String surname;
    private Course[] courses;

    public Course[] getCourses() {
        return this.courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Courses( " + courseArrayToString()+
                '}';
    }

    private String courseArrayToString() {
        String res = null;
        if (courses==null){
            return null;
        }
        for(int i=0;i<courses.length;i++){
            res=res+"Name="+courses[i].getCourseName()+"; ";
        }
        return res;
    }
}
