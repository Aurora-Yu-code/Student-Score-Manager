package com.scores.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 自定义mapper：对表courses的操作
 */

@Mapper
@Repository
public interface CourseMapper {

    @Select("alter table student_score add ${fieldname} varchar(255)")
    int alterTableField(@Param("fieldname") String fieldname);
}
