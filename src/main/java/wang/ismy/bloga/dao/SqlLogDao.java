package wang.ismy.bloga.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wang.ismy.bloga.dao.repository.SqlLogRepository;
import wang.ismy.bloga.entity.SqlLog;

import java.util.List;

@Repository
public class SqlLogDao {

    @Autowired
    private SqlLogRepository sqlLogRepository;

    public SqlLog insert(SqlLog log){
        return sqlLogRepository.save(log);
    }

    public List<SqlLog> insertBatch(List<SqlLog> list){
        return sqlLogRepository.saveAll(list);
    }
}
