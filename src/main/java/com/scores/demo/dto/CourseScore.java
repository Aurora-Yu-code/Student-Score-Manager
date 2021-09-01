package com.scores.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * 搜索的学生成绩信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseScore implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Field
    //课程名称
    private String course;
    @Field
    //课程成绩
    private String score;

}
