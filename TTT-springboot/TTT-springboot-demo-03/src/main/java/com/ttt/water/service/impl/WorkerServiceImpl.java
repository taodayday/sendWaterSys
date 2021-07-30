package com.ttt.water.service.impl;

import com.ttt.water.entities.Customer;
import com.ttt.water.entities.Worker;
import com.ttt.water.mapper.WorkerMapper;
import com.ttt.water.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public List<Worker> listWorker() {
        return workerMapper.listWorker();
    }

    @Override
    public List<Worker> searchWorkerByName(String workerName){
        return workerMapper.searchWorkerByName(workerName);
    }

    @Override
    public int saveWorker(Worker worker){
        return workerMapper.saveWorker(worker);
    }

    @Override
    public Integer deleteWorker(Integer wid){
        return workerMapper.deleteWorker(wid);
    }

    @Override
    public int adjustSalary(Integer wid, Integer workerSalary) {
        return workerMapper.adjustSalary(wid, workerSalary);
    }
}
