package com.scores.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class StudentScoreParam {

    @NotEmpty
    private String number;

    @NotEmpty
    private String name;

    @NotEmpty
    private String chinese;

    @NotEmpty
    private String math;

    @NotEmpty
    private String english;

    @NotEmpty
    private String physics;

    @NotEmpty
    private String chemistry;

    @NotEmpty
    private String geography;

    @NotEmpty
    private String music;

    @NotEmpty
    private String draw;

    @NotEmpty
    private String sport;

    @NotEmpty
    private String computer;


}
