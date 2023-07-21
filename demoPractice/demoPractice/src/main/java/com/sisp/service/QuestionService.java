package com.sisp.service;

import com.sisp.common.utils.UUIDUtil;
import com.sisp.dao.QuestionMapper;
import com.sisp.dao.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionEntity> list(QuestionEntity questionEntity){
        return questionMapper.query(questionEntity);
    }

    public String insert(QuestionEntity questionEntity){
        String id = UUIDUtil.getOneUUID();
        questionEntity.setId(id);
        questionMapper.insert(questionEntity);
        return id;
    }

    public int modify(QuestionEntity questionEntity){
        return questionMapper.update(questionEntity);

    }
    public int delete(QuestionEntity questionEntity){
        return questionMapper.delete(questionEntity);
    }

}
