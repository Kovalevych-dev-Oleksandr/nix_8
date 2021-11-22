package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

public class WorkersDB {
    public static final int START_ARRAY_SIZE = 30;
    private static Worker[] workers = new Worker[START_ARRAY_SIZE];

    public void create(Worker worker) {
        boolean dataRecordingCapability = false;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                workers[i] = worker;
                dataRecordingCapability = true;
                break;
            }
        }
        if (dataRecordingCapability) {
            return;
        }
        Worker[] oldArray = workers;
        Worker[] newArray = new Worker[oldArray.length + START_ARRAY_SIZE];
        workers[oldArray.length] = worker;
    }

    public static void arrayCopy(Worker[] oldArray, Worker newArray[]) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
    }


/*public findById(String id){

}
public void update(Student student) {


}

    public void delete(String id) {

    }

    public Student[] findAll() {

}*/
}