package com.brioal.controller;

import com.brioal.model.ClassifyEntity;
import com.brioal.model.ResultEntity;
import com.brioal.model.UserEntity;
import com.brioal.repository.ClassifyRepository;
import com.brioal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */

@Controller
class ClassifyController {

    @Autowired
    ClassifyRepository mClassifyRepository;

    @Autowired
    UserRepository mUserRepository;

    /**
     * 删除分类
     *
     * @param classifyId
     * @return
     */
    @RequestMapping("/classify/delete")
    @ResponseBody
    public ResultEntity deleteClassify(@RequestParam("classifyid") long classifyId) {
        ResultEntity resultEntity = new ResultEntity();
        try {
            mClassifyRepository.delete(classifyId);
            resultEntity.setSuccess(true);
            resultEntity.setErrorMsg(null);
            resultEntity.setData(null);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setSuccess(false);
            resultEntity.setErrorMsg(e.getMessage());
            resultEntity.setData(null);
        }
        return resultEntity;
    }

    /**
     * 插入分类
     *
     * @param userid
     * @return
     */
    @RequestMapping("/classify/add")
    public @ResponseBody
    ResultEntity<ClassifyEntity> addClassify(@RequestParam("userid") long userid, @RequestParam("name") String name) {
        ResultEntity<ClassifyEntity> resultEntity = new ResultEntity();
        try {
            UserEntity userEntity = mUserRepository.findOne(userid);
            if (userEntity == null) {
                resultEntity.setSuccess(false);
                resultEntity.setErrorMsg("用户不存在");
                resultEntity.setData(null);
            } else {
                ClassifyEntity classifyEntity = new ClassifyEntity();
                classifyEntity.setName(name);
                classifyEntity.setUserid(userEntity.getUserid());
                classifyEntity.setId(System.currentTimeMillis());
                ClassifyEntity entity = mClassifyRepository.saveAndFlush(classifyEntity);
                resultEntity.setData(entity);
                resultEntity.setSuccess(true);
                resultEntity.setErrorMsg(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setSuccess(false);
            resultEntity.setErrorMsg(e.getMessage());
            resultEntity.setData(null);
        }
        return resultEntity;

    }

    /**
     * 根据用户ID返回所有分类
     *
     * @param userId
     * @return
     */
    @RequestMapping("/classify/list")
    public @ResponseBody
    ResultEntity<List<ClassifyEntity>> getClassify(@RequestParam("userid") long userId) {
        ResultEntity result = new ResultEntity();
        try {
            List<ClassifyEntity> list = mClassifyRepository.findAllByUseridEquals(userId);
            if (list == null || list.size() == 0) {
                result.setData(null);
                result.setErrorMsg("找不到数据");
                result.setSuccess(false);
            } else {
                result.setData(list);
                result.setErrorMsg(null);
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setErrorMsg("找不到数据");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 更新数据
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/classify/update")
    public @ResponseBody
    ResultEntity<ClassifyEntity> update(@RequestParam("id") long id, @RequestParam("name") String name) {
        ResultEntity<ClassifyEntity> resultEntity = new ResultEntity<>();
        try {
            mClassifyRepository.updateBlog(name, id);
            ClassifyEntity entity = mClassifyRepository.findOne(id);
            resultEntity.setData(entity);
            resultEntity.setErrorMsg(null);
            resultEntity.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setData(null);
            resultEntity.setErrorMsg(e.getMessage());
            resultEntity.setSuccess(false);
        }
        return resultEntity;
    }
}
