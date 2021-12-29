package ua.com.alevel.entity;

public class Student extends BaseEntity {

    private String name;
    private String surname;
    private HomeWork[] homeWorks;

    public HomeWork[] getHomeWorks() {
        return this.homeWorks;
    }

    public void setHomeWorks(final HomeWork[] homeWorks) {
        this.homeWorks = homeWorks;
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
                "Id='" + super.getId() + +'\'' +
                ",name='" + name + '\'' +
                ", surname='" + surname + '\'' +

                '}';
    }
}
