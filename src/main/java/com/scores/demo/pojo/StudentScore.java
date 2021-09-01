package com.scores.demo.pojo;

public class StudentScore {

    private Integer id;
    private String number;
    private String name;
    private String chinese;
    private String math;
    private String english;
    private String physics;
    private String chemistry;
    private String geography;
    private String music;
    private String draw;
    private String sport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }


    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }


    public String getDraw() {
        return draw;
    }


    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", name=").append(name);
        sb.append(", chinese=").append(chinese);
        sb.append(", math=").append(math);
        sb.append(", english=").append(english);
        sb.append(", physics=").append(physics);
        sb.append(", chemistry=").append(chemistry);
        sb.append(", geography=").append(geography);
        sb.append(", music=").append(music);
        sb.append(", draw=").append(draw);
        sb.append(", sport=").append(sport);
        sb.append("]");
        return sb.toString();
    }
}
