package wang.ismy.bloga.dao.inter;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStayTime {
    int updateStatus(Integer id);
}
