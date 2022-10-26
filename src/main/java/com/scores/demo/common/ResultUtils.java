package com.scores.demo.common;

import com.scores.demo.mbg.model.User;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    private ResultUtils(){
    }

    /**
     * 登录成功返回参数
     * @param user
     * @return
     */
    public static Message loginSuccess(User user){
        Map<String, Object> map = new HashMap<>();
        map.put("number",user.getNumber());
        map.put("name",user.getName());
        map.put("type",user.getType());
        Message message = new Message();
        message.setMsg("登录成功");
        message.setCode("200");
        message.setData(map);
        return message;
    }



    /**
     * 操作成功返回参数
     * @return
     */
    public static Message success(){
        Message message = new Message();
        message.setCode("200");
        message.setMsg("请求成功");
        return message;
    }

    public static Message success(String string){
        Message message = new Message();
        message.setCode("200");
        message.setMsg(string);
        return message;
    }


    public static Message success(Object object){
        Message message = new Message();
        message.setCode("200");
        message.setMsg("请求成功");
        message.setData(object);
        return message;
    }


    /**
     * 操作失败返回参数
     * @param code
     * @param resultMessage
     * @return
     */
    public static Message error(Integer code, String resultMessage){
        Message message = new Message();
        message.setMsg(resultMessage);
        message.setCode(code.toString());
        return message;
    }
}
