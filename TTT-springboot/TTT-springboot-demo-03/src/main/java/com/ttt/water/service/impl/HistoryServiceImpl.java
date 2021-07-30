package com.ttt.water.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ttt.water.entities.History;
import com.ttt.water.mapper.HistoryMapper;
import com.ttt.water.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<History> listHistory() {
        return historyMapper.listHistory();
    }

    @Override
    public int saveHistory( History history){
        return historyMapper.saveHistory(history);
    }


    @Override
    public History getHistoryById(Integer hid) {
        return historyMapper.getHistoryById(hid);
    }

    @Override
    public int updateHistory(History history) {
        return historyMapper.updateHistory(history);
    }

    @Override
    public Integer deleteHistory(Integer wid){
        return historyMapper.deleteHistory(wid);
    }

    @Override
    public int deleteBatchHistory(String ids) {
        // 第一个,替换为null
        ids =ids.replaceFirst(",","");
        String[] split = StrUtil.split(ids, ",");
        List<Integer> idList =  new ArrayList<>();
        for (String id : split) {
            idList.add(Integer.parseInt(id));
        }
        return historyMapper.deleteBatchHistory(idList);
    }
}
