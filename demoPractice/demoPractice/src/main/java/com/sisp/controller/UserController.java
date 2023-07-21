package com.sisp.controller;

import com.sisp.beans.HttpResponseEntity;
import com.sisp.dao.entity.UserEntity;
import com.sisp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 用户登录*/
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity userLogin(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            List<UserEntity> hasUser =userService.selectUserInfo(userEntity);
            System.out.println(hasUser.toString());
            if(CollectionUtils.isEmpty(hasUser)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("登录失败");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasUser.get(0));
                httpResponseEntity.setMessage("登录成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
     * 用户添加*/
    @RequestMapping(value = "/addUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addUserinfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result  =userService.addUserInfo(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
     * 用户修改*/
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyUserinfo(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result  =userService.modifyUserInfo(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
     * 用户删除
     * */
    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deleteUserById(@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result  =userService.deleteUserById(userEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/queryUserList",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryUserList(){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        List<UserEntity> result  =userService.queryUserList();
        try {
            if (CollectionUtils.isEmpty(result)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询失败");
            } else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
