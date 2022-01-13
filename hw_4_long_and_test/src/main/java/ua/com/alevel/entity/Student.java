package ua.com.alevel.entity;

public class Student {
    private String id;
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

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id;  }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + getId() + +'\'' +
                ",name='" + name + '\'' +
                ", surname='" + surname + '\'' +

                '}';
    }
}
