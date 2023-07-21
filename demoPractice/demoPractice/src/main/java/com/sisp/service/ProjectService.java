package com.sisp.service;

import com.sisp.common.utils.UUIDUtil;
import com.sisp.dao.ProjectEntityMapper;
import com.sisp.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity){
        return projectEntityMapper.queryProjectList(projectEntity);
    }

    public int addProjectInfo(ProjectEntity projectEntity){
        projectEntity.setId(UUIDUtil.getOneUUID());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        projectEntity.setCreationDate(LocalDateTime.now().format(formatter));
        projectEntity.setLastUpdateDate(LocalDateTime.now().format(formatter));
        int projectResult = projectEntityMapper.insert(projectEntity);
        if(projectResult != 0){
            return 3;
        }else{
            return projectResult;
        }
    }

    public int modifyProjectInfo(ProjectEntity projectEntity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        projectEntity.setLastUpdateDate(LocalDateTime.now().format(formatter));
        return projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
    }

    public int deleteProjectInfo(ProjectEntity projectEntity){
        return projectEntityMapper.deleteProjectById(projectEntity);
    }
}
