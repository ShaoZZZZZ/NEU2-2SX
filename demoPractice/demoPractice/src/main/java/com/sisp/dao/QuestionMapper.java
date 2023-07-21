package com.sisp.dao;

import com.sisp.dao.entity.QuestionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select * from question_info where questionnaire_id = #{questionnaireId}")
    List<QuestionEntity> query(QuestionEntity questionEntity);
    @Insert("insert into question_info (id, questionnaire_id, question_name, question_content, question_type, question_option) " +
            "values (#{id}, #{questionnaireId}, #{questionName}, #{questionContent}, #{questionType}, #{questionOption});")
    int insert(QuestionEntity questionEntity);
    @Delete("delete from question_info where id = #{id};")
    int delete(QuestionEntity questionEntity);

    int update(QuestionEntity questionEntity);
}
