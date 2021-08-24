package com.scores.demo.dto;

import com.scores.demo.validator.FlagValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginParam {

    @NotEmpty
    private String number;

    @NotEmpty
    private String password;

    @Override
    public String toString() {
        StringBuilder mes = new StringBuilder();
        mes.append("用户号：")
                .append(number)
                .append(" 密码：")
                .append(password);
        return mes.toString();
    }

}
