package com.scores.demo.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * 用户成绩浏览历史记录，文档对象
 *  文档对象的id域添加@Id注解，需要检索的字段添加@Indexed注解
 */
@Document
public class UserReadHistory {
    @Id
    private String id;
    @Indexed //给该字段加索引，提高查询效率
    private String number;
    private String name;
    private String type; //用户类型
    private String content; //操作种类
    private Date createTime;

    public UserReadHistory(){

    }

    public UserReadHistory(String number,String name,String type,String content){
        this.number = number;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    public Date getCreateTime(){
        return this.createTime;
    }
}
