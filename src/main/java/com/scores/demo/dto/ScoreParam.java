package com.scores.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ScoreParam {

    @NotEmpty
    private String number;

    @NotEmpty
    private String name;

    @NotEmpty
    private String courseName;

    @NotEmpty
    private String score;
}
