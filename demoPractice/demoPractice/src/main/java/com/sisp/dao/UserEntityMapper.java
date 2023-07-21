package com.sisp.dao;

import com.sisp.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserEntityMapper {
    /*
    查询用户列表
    */
    List<UserEntity> queryUserList();
    /*
    * 创建用户的基本信息*/
    int insert(UserEntity userEntity);
    /*
    * 根据ID删除用户信息*/
    int deleteUserById(UserEntity userEntity);
    int deleteUserByUsername(UserEntity userEntity);
    /*
    * 根据ID编辑用户信息*/
    int updateByPrimaryKeySelective(UserEntity userEntity);


    List<UserEntity> selectUserInfo(UserEntity userEntity);

}
