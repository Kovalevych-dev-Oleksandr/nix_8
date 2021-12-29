package ua.com.alevel.entity;

import java.util.Arrays;

public class HomeWork extends BaseEntity{
    private String subject;
    private String taskTopic;
    private Student[] students;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTaskTopic() {
        return taskTopic;
    }

    public void setTaskTopic(String taskTopic) {
        this.taskTopic = taskTopic;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "Id='"+ super.getId()+ + '\'' +
                "subject='" + subject + '\'' +
                ", taskTopic='" + taskTopic + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
