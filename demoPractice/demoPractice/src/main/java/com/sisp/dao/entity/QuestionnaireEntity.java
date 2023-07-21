package com.sisp.dao.entity;


import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
public class QuestionnaireEntity {
    private String id;
    private String questionnaireName;
    private Timestamp startTime;
    private Timestamp stopTime;
    private String questionnaireContent;
    private String createdBy;
    private LocalDateTime createDate;
    private String lastUpdatedBy;
    private String questionnaireStatus;
    private LocalDateTime lastUpdateDate;
    private String projectId;
    private String surveyObject;
}
