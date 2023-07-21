package com.sisp.dao;


import com.sisp.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProjectEntityMapper {

    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

    int insert(ProjectEntity projectEntity);

    int updateByPrimaryKeySelective(ProjectEntity projectEntity);

    int deleteProjectById(ProjectEntity projectEntity);
}
