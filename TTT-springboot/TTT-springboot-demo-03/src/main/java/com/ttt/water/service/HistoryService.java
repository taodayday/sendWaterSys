package com.ttt.water.service;



import com.ttt.water.entities.History;

import java.util.List;

/**
 * TODO
 *
 * @author caojie
 * @version 1.0
 * @date 2021/7/24 9:29
 */
public interface HistoryService {

    List<History> listHistory();

    int saveHistory( History history);

    History getHistoryById(Integer hid);

    int updateHistory(History history);

    Integer deleteHistory(Integer wid);

    int deleteBatchHistory(String ids);
}
