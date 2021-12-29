package ua.com.alevel.db.impl;

import ua.com.alevel.db.HomeWorkDB;
import ua.com.alevel.entity.HomeWork;
import ua.com.alevel.entity.Student;

import java.util.Objects;

public class HomeWorkDBImpl implements HomeWorkDB {
    public static HomeWorkDBImpl instance=new HomeWorkDBImpl();
    private static final int START_ARRAY_SIZE = 42;
    private static HomeWork[] homeWorks = new HomeWork[START_ARRAY_SIZE];

    private HomeWorkDBImpl(){}

    public static HomeWorkDBImpl getInstance() {
        return HomeWorkDBImpl.instance;
    }

  /*  public static void clear() {
        students = new Student[START_ARRAY_SIZE];
    }*/

    @Override
    public void create(HomeWork homeWork) {
        boolean dataRecordingCapability = false;
        for (int i = 0; i < homeWorks.length; i++) {
            if (homeWorks[i] == null) {
                homeWorks[i] = homeWork;
                dataRecordingCapability = true;
                break;
            }
        }
        if (dataRecordingCapability) {
            return;
        }
        this.increasingArray(homeWork);
    }


    private void increasingArray(HomeWork  homeWork) {
        HomeWork[] newArray = new HomeWork[homeWorks.length + START_ARRAY_SIZE];
        System.arraycopy(homeWorks, 0, newArray, 0, homeWorks.length);
        homeWorks = newArray;
        homeWorks[homeWorks.length] = homeWork;
    }

    @Override
    public HomeWork findById(String id) {
        int i;
        for (i = 0; i < homeWorks.length; i++) {
            if (homeWorks[i] == null) {
                break;
            }
            if (Objects.equals(homeWorks[i].getId(), id)) {
                return homeWorks[i];
            }
        }
        return null;
    }

    @Override
    public void update(HomeWork  homeWork) {
        HomeWork  current = findById(homeWork.getId());
        if (current != null) {
            current.setSubject(homeWork.getSubject());
            current.setTaskTopic(homeWork.getTaskTopic());
            current.setStudents(homeWork.getStudents());
        }
    }

    @Override
    public void delete(String id) {
        int homeWorkDeletePoint = 0;
        for (int i = 0; i < homeWorks.length; i++) {
            if (null != homeWorks[i] && id.equals(homeWorks[i].getId())) {
                homeWorks[i] = null;
                homeWorkDeletePoint = i;
                break;
            }
        }
         HomeWork[] newArray = new HomeWork[homeWorks.length];

        System.arraycopy(homeWorks, 0, newArray, 0, homeWorkDeletePoint);
        System.arraycopy(homeWorks, homeWorkDeletePoint + 1, newArray, homeWorkDeletePoint, homeWorks.length - (homeWorkDeletePoint + 1));
        homeWorks = newArray;

    }

    @Override
    public HomeWork[] finalAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < homeWorks.length; i++) {
            if (homeWorks[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
        HomeWork[] newResultArray = new HomeWork[sizeResultArray];
        System.arraycopy(homeWorks, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }
}
