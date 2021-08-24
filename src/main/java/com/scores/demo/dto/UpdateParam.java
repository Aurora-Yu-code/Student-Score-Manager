package com.scores.demo.dto;

import com.scores.demo.validator.FlagValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateParam {
    @NotEmpty
    private String number;

    @NotEmpty
    private String oldPassword;

    @NotEmpty
    private String newPassword;

    @Override
    public String toString() {
        StringBuilder mes = new StringBuilder();
        mes.append("用户号：")
                .append(number)
                .append(" 旧密码：")
                .append(oldPassword)
                .append(" 新密码：")
                .append(newPassword);
        return mes.toString();
    }
}
