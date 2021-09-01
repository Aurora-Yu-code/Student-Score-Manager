package com.scores.demo.pojo;

public class Courses {

    private Integer id;
    private String coursename;
    private Integer courseid;

    //无参的构造函数
    public Courses(){

    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCoursename() {
        return coursename;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public Integer getCourseid() {
        return courseid;
    }
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coursename=").append(coursename);
        sb.append("]");
        return sb.toString();
    }
}
