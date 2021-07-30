package com.ttt.water.service;


import com.ttt.water.entities.Customer;
import com.ttt.water.entities.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> listWorker();

    List<Worker> searchWorkerByName(String workerName);

    int saveWorker(Worker worker);

    Integer deleteWorker(Integer wid);

    int adjustSalary( Integer wid, Integer workerSalary);

}
