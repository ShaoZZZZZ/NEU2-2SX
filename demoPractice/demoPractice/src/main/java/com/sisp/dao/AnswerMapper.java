package com.sisp.dao;

import com.sisp.dao.entity.AnswerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Insert("insert into answer_info" +
            " (id, questionnaire_id, role_id, answer_time, answer_status, answer) " +
            "values (#{id}, #{questionnaireId}, #{roleId}, #{answerTime}, #{answerStatus}, #{answer});")
    int insert(AnswerEntity answerEntity);

    @Select("select * from answer_info where questionnaire_id = #{questionnaireId};")
    List<AnswerEntity> list(AnswerEntity answerEntity);

}
