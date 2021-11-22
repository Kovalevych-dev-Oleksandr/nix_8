package ua.com.alevel.entity;

public class Worker {
    private String id;
    private String firstName;
    private int lastName;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return this.lastName;
    }

    public void setLastName(final int lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id='" + id + '\'' +
                ",First Name='" + firstName  + '\'' +
                ", Last Name'" + lastName + '\'' +
                '}';
    }
}
