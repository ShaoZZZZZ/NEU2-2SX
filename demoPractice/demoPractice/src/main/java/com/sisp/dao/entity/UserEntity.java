package com.sisp.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
public class UserEntity implements Serializable {
    private String id;
    private String username;
    private String password;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;
    private String createdBy;
    private LocalDateTime creationDate;
    private String lastUpdateBy;
    private LocalDateTime lastUpdateDate;

}
