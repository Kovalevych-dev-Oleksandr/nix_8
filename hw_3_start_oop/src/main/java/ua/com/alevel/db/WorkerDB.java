package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

import java.util.Objects;
import java.util.UUID;

public class WorkerDB {
    public static final int START_ARRAY_SIZE = 30;
    private static final Worker[] workers = new Worker[WorkerDB.START_ARRAY_SIZE];

    public void create(final Worker worker) {
        boolean dataRecordingCapability = false;
        for (int i = 0; i < WorkerDB.workers.length; i++) {
            if (WorkerDB.workers[i] == null) {
                WorkerDB.workers[i] = worker;
                dataRecordingCapability = true;
                break;
            }
        }
        if (dataRecordingCapability) {
            return;
        }
        final Worker[] oldArray = WorkerDB.workers;
        final Worker[] newArray = new Worker[oldArray.length + WorkerDB.START_ARRAY_SIZE];
        System.arraycopy(oldArray, 0, WorkerDB.workers, 0, oldArray.length);
        WorkerDB.workers[oldArray.length] = worker;
    }

    public void update(final Worker worker) {
        Worker current = findById(worker.getId());
        if (current != null) {
            current.setFirstName(worker.getFirstName());
            current.setPatronymic(worker.getPatronymic());
            current.setLastName(worker.getLastName());
        }
    }

    public static Worker findById(final String id) {
        int i;
        for (i = 0; i < WorkerDB.workers.length; i++) {
            if (workers[i] == null) {
                break;
            }
            if (Objects.equals(workers[i].getId(), id)) {
                return workers[i];
            }
        }
        return null;
    }

    public static Worker[] findAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < WorkerDB.workers.length; i++) {
            if (WorkerDB.workers[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
        final Worker[] newResultArray = new Worker[sizeResultArray];
        System.arraycopy(WorkerDB.workers, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }


    public void delete(final String id) {
        int workerDeletePoint = 0;
        for (int i = 0; i < WorkerDB.workers.length; i++) {
            if (WorkerDB.workers[i] != null && id.equals(WorkerDB.workers[i].getId())) {
                WorkerDB.workers[i] = null;
                workerDeletePoint = i;
                break;
            }
        }
        for (int i = workerDeletePoint; i < WorkerDB.workers.length; i++) {
            if (WorkerDB.workers[i + 1] == null) {
                break;
            } else {
                WorkerDB.workers[i] = WorkerDB.workers[i + 1];
                WorkerDB.workers[i + 1] = null;
            }
        }

    }

    public static String generateId() {
        final String id = UUID.randomUUID().toString();
        for (int i = 0; i < WorkerDB.workers.length; i++) {
            if (WorkerDB.workers[i] == null) break;
            if (id.equals(WorkerDB.workers[i].getId())) {
                return WorkerDB.generateId();
            }
        }
        return id;
    }

}