package com.brioal.controller;

import com.brioal.model.ResultEntity;
import com.brioal.model.UserEntity;
import com.brioal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */
@Controller
class UserController {

    @Autowired
    UserRepository mUserRepository;

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping("/user/add")
    public @ResponseBody
    ResultEntity addUser(@RequestParam("username") String useName, @RequestParam("password") String passWord, @RequestParam("email") String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setUsername(useName);
        userEntity.setPassword(passWord);
        userEntity.setUserid(System.currentTimeMillis());
        //保存到数据库
        ResultEntity<UserEntity> result = new ResultEntity<>();
        try {
            UserEntity user = mUserRepository.save(userEntity);
            result.setData(user);
            result.setErrorMsg(null);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setErrorMsg(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 用户登陆
     *
     * @param userName
     * @param passWord
     * @param email
     * @return
     */
    @RequestMapping("/user/login")
    public @ResponseBody
    ResultEntity<UserEntity> login(@RequestParam("username") String userName, @RequestParam("password") String passWord, @RequestParam("email") String email) {
        ResultEntity<UserEntity> result = new ResultEntity<>();
        UserEntity user = null;
        //优先邮箱
        if (email != null && passWord != null && !email.isEmpty() && !passWord.isEmpty()) {
            try {
                user = mUserRepository.findUserEntityByEmailEqualsAndPasswordEquals(email, passWord);
                if (user == null) {
                    System.out.println("找不到数据");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userName != null && passWord != null && !userName.isEmpty() && !passWord.isEmpty()) {
            //按用户名查找
            try {
                user = mUserRepository.findUserEntityByUsernameEqualsAndPasswordEquals(userName, passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (user != null) {
            result.setSuccess(true);
            result.setErrorMsg(null);
            result.setData(user);
        } else {
            result.setSuccess(false);
            result.setErrorMsg("用户信息错误");
            result.setData(null);
        }
        return result;
    }
}
