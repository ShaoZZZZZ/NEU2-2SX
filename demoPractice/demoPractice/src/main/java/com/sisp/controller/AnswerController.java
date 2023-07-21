package com.sisp.controller;

import com.sisp.beans.HttpResponseEntity;
import com.sisp.dao.entity.AnswerEntity;
import com.sisp.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping("/insert")
    public HttpResponseEntity insert(@RequestBody AnswerEntity answerEntity){
        answerService.insert(answerEntity);
        HttpResponseEntity entity = new HttpResponseEntity();
        entity.setCode("666");
        entity.setMessage("提交成功");
        return entity;
    }

    @PostMapping("/list")
    public HttpResponseEntity list(@RequestBody AnswerEntity answerEntity){
        List<AnswerEntity> list = answerService.list(answerEntity);
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
}
