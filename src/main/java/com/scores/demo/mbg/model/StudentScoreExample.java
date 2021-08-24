package com.scores.demo.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public StudentScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andChineseIsNull() {
            addCriterion("chinese is null");
            return (Criteria) this;
        }

        public Criteria andChineseIsNotNull() {
            addCriterion("chinese is not null");
            return (Criteria) this;
        }

        public Criteria andChineseEqualTo(String value) {
            addCriterion("chinese =", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotEqualTo(String value) {
            addCriterion("chinese <>", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThan(String value) {
            addCriterion("chinese >", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThanOrEqualTo(String value) {
            addCriterion("chinese >=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThan(String value) {
            addCriterion("chinese <", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThanOrEqualTo(String value) {
            addCriterion("chinese <=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLike(String value) {
            addCriterion("chinese like", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotLike(String value) {
            addCriterion("chinese not like", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseIn(List<String> values) {
            addCriterion("chinese in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotIn(List<String> values) {
            addCriterion("chinese not in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseBetween(String value1, String value2) {
            addCriterion("chinese between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotBetween(String value1, String value2) {
            addCriterion("chinese not between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andMathIsNull() {
            addCriterion("math is null");
            return (Criteria) this;
        }

        public Criteria andMathIsNotNull() {
            addCriterion("math is not null");
            return (Criteria) this;
        }

        public Criteria andMathEqualTo(String value) {
            addCriterion("math =", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotEqualTo(String value) {
            addCriterion("math <>", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThan(String value) {
            addCriterion("math >", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThanOrEqualTo(String value) {
            addCriterion("math >=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThan(String value) {
            addCriterion("math <", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThanOrEqualTo(String value) {
            addCriterion("math <=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLike(String value) {
            addCriterion("math like", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotLike(String value) {
            addCriterion("math not like", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathIn(List<String> values) {
            addCriterion("math in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotIn(List<String> values) {
            addCriterion("math not in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathBetween(String value1, String value2) {
            addCriterion("math between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotBetween(String value1, String value2) {
            addCriterion("math not between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNull() {
            addCriterion("english is null");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNotNull() {
            addCriterion("english is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishEqualTo(String value) {
            addCriterion("english =", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotEqualTo(String value) {
            addCriterion("english <>", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThan(String value) {
            addCriterion("english >", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThanOrEqualTo(String value) {
            addCriterion("english >=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThan(String value) {
            addCriterion("english <", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThanOrEqualTo(String value) {
            addCriterion("english <=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLike(String value) {
            addCriterion("english like", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotLike(String value) {
            addCriterion("english not like", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishIn(List<String> values) {
            addCriterion("english in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotIn(List<String> values) {
            addCriterion("english not in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishBetween(String value1, String value2) {
            addCriterion("english between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotBetween(String value1, String value2) {
            addCriterion("english not between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andPhysicsIsNull() {
            addCriterion("physics is null");
            return (Criteria) this;
        }

        public Criteria andPhysicsIsNotNull() {
            addCriterion("physics is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicsEqualTo(String value) {
            addCriterion("physics =", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotEqualTo(String value) {
            addCriterion("physics <>", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsGreaterThan(String value) {
            addCriterion("physics >", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsGreaterThanOrEqualTo(String value) {
            addCriterion("physics >=", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLessThan(String value) {
            addCriterion("physics <", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLessThanOrEqualTo(String value) {
            addCriterion("physics <=", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsLike(String value) {
            addCriterion("physics like", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotLike(String value) {
            addCriterion("physics not like", value, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsIn(List<String> values) {
            addCriterion("physics in", values, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotIn(List<String> values) {
            addCriterion("physics not in", values, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsBetween(String value1, String value2) {
            addCriterion("physics between", value1, value2, "physics");
            return (Criteria) this;
        }

        public Criteria andPhysicsNotBetween(String value1, String value2) {
            addCriterion("physics not between", value1, value2, "physics");
            return (Criteria) this;
        }

        public Criteria andChemistryIsNull() {
            addCriterion("chemistry is null");
            return (Criteria) this;
        }

        public Criteria andChemistryIsNotNull() {
            addCriterion("chemistry is not null");
            return (Criteria) this;
        }

        public Criteria andChemistryEqualTo(String value) {
            addCriterion("chemistry =", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotEqualTo(String value) {
            addCriterion("chemistry <>", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryGreaterThan(String value) {
            addCriterion("chemistry >", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryGreaterThanOrEqualTo(String value) {
            addCriterion("chemistry >=", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLessThan(String value) {
            addCriterion("chemistry <", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLessThanOrEqualTo(String value) {
            addCriterion("chemistry <=", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryLike(String value) {
            addCriterion("chemistry like", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotLike(String value) {
            addCriterion("chemistry not like", value, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryIn(List<String> values) {
            addCriterion("chemistry in", values, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotIn(List<String> values) {
            addCriterion("chemistry not in", values, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryBetween(String value1, String value2) {
            addCriterion("chemistry between", value1, value2, "chemistry");
            return (Criteria) this;
        }

        public Criteria andChemistryNotBetween(String value1, String value2) {
            addCriterion("chemistry not between", value1, value2, "chemistry");
            return (Criteria) this;
        }

        public Criteria andGeographyIsNull() {
            addCriterion("geography is null");
            return (Criteria) this;
        }

        public Criteria andGeographyIsNotNull() {
            addCriterion("geography is not null");
            return (Criteria) this;
        }

        public Criteria andGeographyEqualTo(String value) {
            addCriterion("geography =", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyNotEqualTo(String value) {
            addCriterion("geography <>", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyGreaterThan(String value) {
            addCriterion("geography >", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyGreaterThanOrEqualTo(String value) {
            addCriterion("geography >=", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyLessThan(String value) {
            addCriterion("geography <", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyLessThanOrEqualTo(String value) {
            addCriterion("geography <=", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyLike(String value) {
            addCriterion("geography like", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyNotLike(String value) {
            addCriterion("geography not like", value, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyIn(List<String> values) {
            addCriterion("geography in", values, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyNotIn(List<String> values) {
            addCriterion("geography not in", values, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyBetween(String value1, String value2) {
            addCriterion("geography between", value1, value2, "geography");
            return (Criteria) this;
        }

        public Criteria andGeographyNotBetween(String value1, String value2) {
            addCriterion("geography not between", value1, value2, "geography");
            return (Criteria) this;
        }

        public Criteria andMusicIsNull() {
            addCriterion("music is null");
            return (Criteria) this;
        }

        public Criteria andMusicIsNotNull() {
            addCriterion("music is not null");
            return (Criteria) this;
        }

        public Criteria andMusicEqualTo(String value) {
            addCriterion("music =", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotEqualTo(String value) {
            addCriterion("music <>", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThan(String value) {
            addCriterion("music >", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThanOrEqualTo(String value) {
            addCriterion("music >=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThan(String value) {
            addCriterion("music <", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThanOrEqualTo(String value) {
            addCriterion("music <=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLike(String value) {
            addCriterion("music like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotLike(String value) {
            addCriterion("music not like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicIn(List<String> values) {
            addCriterion("music in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotIn(List<String> values) {
            addCriterion("music not in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicBetween(String value1, String value2) {
            addCriterion("music between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotBetween(String value1, String value2) {
            addCriterion("music not between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andDrawIsNull() {
            addCriterion("draw is null");
            return (Criteria) this;
        }

        public Criteria andDrawIsNotNull() {
            addCriterion("draw is not null");
            return (Criteria) this;
        }

        public Criteria andDrawEqualTo(String value) {
            addCriterion("draw =", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotEqualTo(String value) {
            addCriterion("draw <>", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawGreaterThan(String value) {
            addCriterion("draw >", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawGreaterThanOrEqualTo(String value) {
            addCriterion("draw >=", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawLessThan(String value) {
            addCriterion("draw <", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawLessThanOrEqualTo(String value) {
            addCriterion("draw <=", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawLike(String value) {
            addCriterion("draw like", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotLike(String value) {
            addCriterion("draw not like", value, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawIn(List<String> values) {
            addCriterion("draw in", values, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotIn(List<String> values) {
            addCriterion("draw not in", values, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawBetween(String value1, String value2) {
            addCriterion("draw between", value1, value2, "draw");
            return (Criteria) this;
        }

        public Criteria andDrawNotBetween(String value1, String value2) {
            addCriterion("draw not between", value1, value2, "draw");
            return (Criteria) this;
        }

        public Criteria andSportIsNull() {
            addCriterion("sport is null");
            return (Criteria) this;
        }

        public Criteria andSportIsNotNull() {
            addCriterion("sport is not null");
            return (Criteria) this;
        }

        public Criteria andSportEqualTo(String value) {
            addCriterion("sport =", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotEqualTo(String value) {
            addCriterion("sport <>", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThan(String value) {
            addCriterion("sport >", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportGreaterThanOrEqualTo(String value) {
            addCriterion("sport >=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThan(String value) {
            addCriterion("sport <", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLessThanOrEqualTo(String value) {
            addCriterion("sport <=", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportLike(String value) {
            addCriterion("sport like", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotLike(String value) {
            addCriterion("sport not like", value, "sport");
            return (Criteria) this;
        }

        public Criteria andSportIn(List<String> values) {
            addCriterion("sport in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotIn(List<String> values) {
            addCriterion("sport not in", values, "sport");
            return (Criteria) this;
        }

        public Criteria andSportBetween(String value1, String value2) {
            addCriterion("sport between", value1, value2, "sport");
            return (Criteria) this;
        }

        public Criteria andSportNotBetween(String value1, String value2) {
            addCriterion("sport not between", value1, value2, "sport");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table student_score
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 18 11:03:11 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table student_score
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}