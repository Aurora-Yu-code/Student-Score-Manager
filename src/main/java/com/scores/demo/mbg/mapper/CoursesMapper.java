package com.scores.demo.mbg.mapper;

import com.scores.demo.mbg.model.Courses;
import com.scores.demo.mbg.model.CoursesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int countByExample(CoursesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int deleteByExample(CoursesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int insert(Courses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int insertSelective(Courses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    List<Courses> selectByExample(CoursesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    Courses selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int updateByExampleSelective(@Param("record") Courses record, @Param("example") CoursesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int updateByExample(@Param("record") Courses record, @Param("example") CoursesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int updateByPrimaryKeySelective(Courses record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbggenerated Wed Aug 18 11:03:11 CST 2021
     */
    int updateByPrimaryKey(Courses record);
}