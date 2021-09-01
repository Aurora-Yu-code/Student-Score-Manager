package com.scores.demo.Mapper;

import com.scores.demo.pojo.Courses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface coursesmapper {
    //根据id查询
    Courses selectById(int id);
    //根据课程名查询
    Courses selectByCourse(String coursename);
    //查询全部课程
    List<Courses> selectAll();

    //根据id删除课程
    int deleteById(int id);
    //根据课程名删除课程
    int deleteByCourse(String coursename);

    //插入某个课程
    Integer insertCourse(String coursename);

    //根据添加的课程修改student_score的字段
    int alterTableField(String fieldname);
    //根据课程名修改student_score的字段
    int deleteTableField(String fieldname);

}
