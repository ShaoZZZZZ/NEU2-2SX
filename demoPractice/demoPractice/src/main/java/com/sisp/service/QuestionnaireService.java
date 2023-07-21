package com.sisp.service;

import com.sisp.common.utils.UUIDUtil;
import com.sisp.dao.QuestionnaireMapper;
import com.sisp.dao.entity.QuestionEntity;
import com.sisp.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    public List<QuestionnaireEntity> queryList(QuestionnaireEntity questionnaireEntity){
        return questionnaireMapper.queryQuestionnaireList(questionnaireEntity);
    }

    public String  insert(QuestionnaireEntity questionnaireEntity){
        String id = UUIDUtil.getOneUUID();
        questionnaireEntity.setId(id);
        questionnaireMapper.insert(questionnaireEntity);
        return id;
    }

    public int delete(QuestionnaireEntity questionnaireEntity){
        return questionnaireMapper.delete(questionnaireEntity);
    }

    public int modify(QuestionnaireEntity questionnaireEntity){
        return questionnaireMapper.update(questionnaireEntity);
    }
}
