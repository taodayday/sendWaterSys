package com.ttt.water.mapper;

import com.ttt.water.entities.Customer;
import com.ttt.water.entities.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author caojie
 * @version 1.0
 * @date 2021/7/24 9:18
 */
public interface HistoryMapper {
    /**
     * 显示所有送水历史信息
     * @return 送水历史列表
     */
    List<History> listHistory();

    List<History> searchHistory(String historyStart,String historyEnd);

    int saveHistory( History history);

    History getHistoryById(Integer hid);

    int updateHistory(History history);

    Integer deleteHistory(Integer wid);

    int deleteBatchHistory(@Param("idList") List<Integer> idList);

}
