package net.educoder.mapper;

import net.educoder.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Step1Mapper {


    /********** Begin **********/

    @Select("SELECT * FROM monitoring")
    List<User> findMonitoringUser();

    /********** End **********/

    @Select("select * from monitoring where 1=0")
    void init();
}
