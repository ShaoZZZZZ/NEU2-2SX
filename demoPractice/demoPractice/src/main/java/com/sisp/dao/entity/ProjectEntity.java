package com.sisp.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectEntity implements Serializable {
    private String id;
    private String userId;

    private String projectName;

    private String projectContent;

    private String createdBy;

    private String creationDate;

    private String lastUpdatedBy;

    private String lastUpdateDate;

}
