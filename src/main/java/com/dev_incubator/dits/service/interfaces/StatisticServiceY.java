package com.dev_incubator.dits.service.interfaces;

import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.StatisticY;
import com.dev_incubator.dits.persistence.entity.UserY;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StatisticServiceY {
    Map<String, StatisticY> statList = new HashMap<>();
    List<StatisticY> findAllStatistics();
    void saveMapOfStat(Map<String, StatisticY> map, Timestamp endTest);
    void changeCorrectValue(Timestamp date, UserY userY, QuestionY questionY, boolean
            correct);
    List<StatisticY> findAllByDate(Timestamp date);
    List<StatisticY> getAllByDate(Timestamp date);
}
