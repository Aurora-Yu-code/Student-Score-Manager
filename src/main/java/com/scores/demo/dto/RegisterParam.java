package com.scores.demo.dto;

import com.scores.demo.validator.FlagValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class RegisterParam {

    @NotEmpty
    private String number;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotNull
    @FlagValidator({"1","2","3"})
    private Integer type;

    @Override
    public String toString() {
        StringBuilder mes = new StringBuilder();
        mes.append("用户号：")
                .append(number)
                .append(" 密码：")
                .append(password)
                .append(" 用户名：")
                .append(name)
                .append(" 用户类型：")
                .append(type)
                .append(" 1 老师 2 学生 3 系统管理员");
        return mes.toString();
    }
}
