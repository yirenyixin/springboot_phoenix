package net.educoder.mapper;

import net.educoder.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Step2Mapper {

    /********** Begin **********/
    @Select("SELECT * FROM eventLog WHERE code = #{id}")
    List<Event> findEventsByCode(String id);


    /********** End **********/
}
