package com.scores.demo.Mapper;

import com.scores.demo.mbg.model.StudentScore;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义mapper：对表student_score的操作
 */

@Mapper
@Repository
public interface ScoreMapper {

    @Select("select number from student_score")
    List<String> findNumbers();

    @Select("select ${courseName} from student_score")
    List<String> findScoreByCourseName(@Param("courseName") String courseName);

    @Select("select * from student_score where id = #{id}")
    List<String> findScoreById(@Param("id") Integer id);

    @Select("select number from student_score limit ${pageStart},${pageSize}")
    List<String> findNumbersLimit(@Param("pageStart")Integer pageStart, @Param("pageSize")Integer pageSize);

    @Select("select ${courseName} from student_score limit ${pageStart},${pageSize}")
    List<String> findScoreByCourseNameLimit(@Param("pageStart")Integer pageStart, @Param("pageSize")Integer pageSize,
                                  @Param("courseName") String courseName);

    @Update("update student_score set ${courseName} = #{score} where number = #{number}")
    int updateScoreByCourseNameandNumber(@Param("number") String number,@Param("courseName") String courseName,
                                         @Param("score")String score);
}
