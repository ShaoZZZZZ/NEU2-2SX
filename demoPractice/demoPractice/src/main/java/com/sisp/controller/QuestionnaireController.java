package com.sisp.controller;

import com.sisp.beans.HttpResponseEntity;
import com.sisp.dao.entity.QuestionnaireEntity;
import com.sisp.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/list")
    public HttpResponseEntity list(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        List<QuestionnaireEntity> entities = questionnaireService.queryList(questionnaireEntity);
        httpResponseEntity.setData(entities);
        return httpResponseEntity;
    }
    @PostMapping("/insert")
    public HttpResponseEntity insert(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        String id = questionnaireService.insert(questionnaireEntity);
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(id);
        return httpResponseEntity;
    }

    @PostMapping("/update")
    public HttpResponseEntity update(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        questionnaireService.modify(questionnaireEntity);
        httpResponseEntity.setCode("666");
        return httpResponseEntity;
    }

    @PostMapping("/delete")
    public HttpResponseEntity delete(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        questionnaireService.delete(questionnaireEntity);
        httpResponseEntity.setCode("666");
        return httpResponseEntity;
    }

}
