package com.sisp.dao.entity;

import lombok.Data;

@Data
public class QuestionEntity {
    private String id;
    private String isMust;
    private String questionnaireId;
    private String questionName;
    private String questionContent;
    private String questionType;
    private String questionOption;
}
