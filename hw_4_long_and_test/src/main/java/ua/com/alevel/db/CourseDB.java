package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

import java.util.Objects;
import java.util.UUID;

public class CourseDB {
    private static final CourseDB instance = new CourseDB();
    private static final int START_ARRAY_SIZE = 30;
    private static Course[] courses = new Course[START_ARRAY_SIZE];

    public CourseDB() {}

    public static CourseDB getInstance() {
        return instance;
    }

    public String create(Course course) {
        course.setId(generateId());
        boolean dataRecordingCapability = false;
        for (int i = 0; i < courses.length; i++) {
            if (null == courses[i]) {
                courses[i] = course;
                dataRecordingCapability = true;
                break;
            }
        }
        if (!dataRecordingCapability) {
            this.increasingArray(course);
        }
       return "Student was create";
    }

    public void clear() {
        courses = new Course[START_ARRAY_SIZE];
    }

    private void increasingArray(Course course) {
        Course[] newArray = new Course[courses.length + START_ARRAY_SIZE];
        System.arraycopy(courses, 0, newArray, 0, courses.length);
        courses = newArray;
        courses[courses.length] = course;
    }

    public void update(Course course) {//course
        Course current = this.findById(course.getId());
        if (current != null) {
            current.setCourseName(course.getCourseName());
            current.setStudents(course.getStudents());
        }
    }

    public Course findById(String id) {
        int i;
        for (i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                break;
            }
            if (Objects.equals(courses[i].getId(), id)) {
                return courses[i];
            }
        }
        return null;
    }

    public Course[] findAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
        Course[] newResultArray = new Course[sizeResultArray];
        System.arraycopy(courses, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }

    public void delete(final String id) {
        int workerDeletePoint = 0;
        for (int i = 0; i < courses.length; i++) {
            if (null != courses[i] && id.equals(courses[i].getId())) {
                courses[i] = null;
                workerDeletePoint = i;
                break;
            }
        }
        Course[] newArray = new Course[courses.length];

        System.arraycopy(courses, 0, newArray, 0, workerDeletePoint);
        System.arraycopy(courses, workerDeletePoint + 1, newArray, workerDeletePoint, courses.length - (workerDeletePoint + 1));
        courses = newArray;

    }

    private String generateId() {
        String id;
        do {
            id = this.generateStringUUID();
        } while (this.existId(id));
        return id;
    }

    private boolean existId(String id) {
        for (Course course : courses) {
            if (null == course) break;
            if (id.equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    private String generateStringUUID() {
        return String.copyValueOf(UUID.randomUUID().toString().toCharArray(),0,4);
    }
}
