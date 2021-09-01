package com.scores.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UpdateCourseParam {
    @NotEmpty
    private String coursename;

    @NotEmpty
    private String courseid;

    @NotEmpty
    private String oldcoursename;

    @Override
    public String toString() {
        StringBuilder mes = new StringBuilder();
        mes.append("课程名：")
                .append(coursename)
                .append(" 课程id：")
                .append(courseid)
                .append(" 旧课程：")
                .append(oldcoursename);
        return mes.toString();
    }
}
