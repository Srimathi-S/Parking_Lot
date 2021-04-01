package utility;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<Worker> workerList = new ArrayList<>();

    public void addWorker(Worker worker) {
        workerList.add(worker);
    }

    public void notifyIsFull() {
        workerList.forEach(Worker::notifyIsFull);
    }

    public void notifyIsNotFull() {
        workerList.forEach(Worker::notifyIsNotFull);
    }
}
