package com.sisp.dao.entity;


import lombok.Data;

import java.sql.Timestamp;
@Data
public class AnswerEntity {
    private String id;
    private String questionnaireId;
    private String roleId;
    private Timestamp answerTime;
    private String answerStatus;
    private String answer;
}
