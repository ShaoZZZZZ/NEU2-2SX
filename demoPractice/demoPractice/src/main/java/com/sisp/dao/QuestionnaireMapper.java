package com.sisp.dao;

import com.sisp.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionnaireMapper {
    @Select("select * from questionnaire_info where project_id = #{projectId};")
    List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity);
    @Insert("insert into questionnaire_info " +
            "(id, questionnaire_name, questionnaire_content, created_by, create_date, last_updated_by," +
            " questionnaire_status, last_update_date, project_id, start_time, stop_time, survey_object) values (#{id}, #{questionnaireName}, #{questionnaireContent}, " +
            "#{createdBy}, #{createDate}, #{lastUpdatedBy},#{questionnaireStatus}, #{lastUpdateDate}, #{projectId}, #{startTime}, #{stopTime}, #{surveyObject});")
    int insert(QuestionnaireEntity questionnaireEntity);
    @Delete("delete from questionnaire_info where id = #{id}")
    int delete(QuestionnaireEntity questionnaireEntity);

    int update(QuestionnaireEntity questionnaireEntity);
    @Select("select * from questionnaire_info where id = #{id}")
    QuestionnaireEntity selectOne(QuestionnaireEntity questionnaireEntity);
}
