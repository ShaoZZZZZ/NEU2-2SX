package com.sisp.controller;

import com.sisp.beans.HttpResponseEntity;
import com.sisp.dao.entity.QuestionEntity;
import com.sisp.dao.entity.QuestionnaireEntity;
import com.sisp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/list")
    public HttpResponseEntity list(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        List<QuestionEntity> list = questionService.list(questionEntity);
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
    @PostMapping("/insert")
    public HttpResponseEntity insert(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        String id = questionService.insert(questionEntity);
        httpResponseEntity.setData(id);
        return httpResponseEntity;
    }

    @PostMapping("/update")
    public HttpResponseEntity update(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        questionService.modify(questionEntity);
        return httpResponseEntity;
    }

    @PostMapping("/delete")
    public HttpResponseEntity delete(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        questionService.delete(questionEntity);
        return httpResponseEntity;
    }
}
