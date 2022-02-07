package ua.com.alevel.entity;

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
                "Id='" + super.getId()+ +'\'' +
                "',name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
