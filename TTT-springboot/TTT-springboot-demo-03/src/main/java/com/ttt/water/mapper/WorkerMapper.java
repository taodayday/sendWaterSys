package com.ttt.water.mapper;

import com.ttt.water.entities.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerMapper {
    List<Worker> listWorker();

    List<Worker> searchWorkerByName(@Param("workerName") String workerName);

    int saveWorker(Worker worker);

    Integer deleteWorker(Integer wid);

    int adjustSalary(@Param("wid") Integer wid, @Param("workerSalary") Integer workerSalary);
}
