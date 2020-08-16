/*
package com.dev_incubator.dits.service.Y;

import com.dev_incubator.dits.persistence.entity.Y.QuestionY;
import com.dev_incubator.dits.persistence.entity.Y.StatisticY;
import com.dev_incubator.dits.persistence.entity.Y.UserY;
import com.dev_incubator.dits.persistence.repository.Y.StatisticRepositoryY;
import com.dev_incubator.dits.service.interfaces.Y.StatisticServiceY;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class StatisticServiceImplY implements StatisticServiceY {

    private final StatisticRepositoryY statisticRepositoryY;

    @Override
    public List<StatisticY> findAllStatistics() {
        return statisticRepositoryY.findAll();
    }

    public void saveMapOfStat(Map<String, StatisticY> map, Timestamp
            endTest) {
        for (StatisticY statistic : map.values()) {
            statistic.setDate(endTest);
            statisticRepositoryY.save(statistic);
        }
    }

    @Override
    public void changeCorrectValue(Timestamp date, UserY userY,
                                   QuestionY questionY, boolean correct) {
        statisticRepositoryY.changeCorrectValue(date, userY, questionY,
                correct);
    }

    @Override
    public List<StatisticY> findAllByDate(Timestamp date) {
        return statisticRepositoryY.findAllByDate(date);
    }

    @Override
    public List<StatisticY> getAllByDate(Timestamp date) {
        return statisticRepositoryY.getAllByDate(date);
    }
}
*/
