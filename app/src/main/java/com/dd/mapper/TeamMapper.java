package com.dd.mapper;

import com.dd.model.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeamMapper {

  @Select("select id, name from teams where id = #{id}")
  Team findById(@Param("id") Long id);

  @Select("insert into teams (name) values (#{name}) returning id")
  Long insert(@Param("name") String name);

}
