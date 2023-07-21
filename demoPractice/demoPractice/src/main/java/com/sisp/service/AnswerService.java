package com.sisp.service;


import com.sisp.common.utils.UUIDUtil;
import com.sisp.dao.AnswerMapper;
import com.sisp.dao.entity.AnswerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    public int insert(AnswerEntity answerEntity){
        answerEntity.setId(UUIDUtil.getOneUUID());
        answerEntity.setAnswerTime(Timestamp.valueOf(LocalDateTime.now()));
        return answerMapper.insert(answerEntity);
    }

    public List<AnswerEntity> list(AnswerEntity answerEntity){
        return answerMapper.list(answerEntity);
    }
}
