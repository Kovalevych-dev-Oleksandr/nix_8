package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

import java.util.UUID;

public class WorkerDB {
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
        System.arraycopy(oldArray, 0, workers, 0, oldArray.length);
        workers[oldArray.length] = worker;
    }

    public void update(Worker worker) {

        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getId() == worker.getId() && workers[i] != null) {
                workers[i].setFirstName(worker.getFirstName());
                workers[i].setLastName(worker.getLastName());
            }
        }
    }

    public static Worker findById(String id) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && id == workers[i].getId()) {
                return workers[i];
            }
        }

        return null;
    }

    public static Worker[] findAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
        Worker newResultArray[] = new Worker[sizeResultArray];
        System.arraycopy(workers, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }


    public void delete(String id) {
        int workerDeletePoint = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && id.equals(workers[i].getId())) {
                workers[i] = null;
                workerDeletePoint = i;
                break;
            }
        }
        for (int i = workerDeletePoint; i < workers.length; i++) {
            if (workers[i + 1] == null) {
                break;
            } else {
                workers[i] = workers[i + 1];
                workers[i + 1] = null;
            }
        }

    }

    public static String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) break;
            if (id.equals(workers[i].getId())) {
                return generateId();
            }
        }
        return id;
    }

}