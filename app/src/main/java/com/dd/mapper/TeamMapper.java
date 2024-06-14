package com.dd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeamMapper {

  @Select("insert into teams (name) values (#{name}) returning id")
  Long insert(@Param("name") String name);

}
