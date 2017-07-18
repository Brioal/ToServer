package com.brioal.controller;

import com.brioal.model.ListEntity;
import com.brioal.model.ResultEntity;
import com.brioal.repository.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 加载任务列表
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */
@Controller
class TodoController {

    @Autowired
    ListRepository mListRepository;

    /**
     * 添加任务
     *
     * @param detail
     * @param classifyID
     * @param userId
     * @return
     */
    @RequestMapping("/todo/add")
    public @ResponseBody
    ResultEntity<ListEntity> addTodo(@RequestParam("detail") String detail, @RequestParam("classifyid") long classifyID, @RequestParam("userid") long userId) {
        ResultEntity<ListEntity> resultEntity = new ResultEntity<>();
        try {
            ListEntity entity = new ListEntity();
            entity.setDetail(detail);
            entity.setClassifyid(classifyID);
            entity.setUserid(userId);
            entity.setId(System.currentTimeMillis());
            ListEntity returnEntity = mListRepository.saveAndFlush(entity);
            if (resultEntity != null) {
                resultEntity.setData(returnEntity);
                resultEntity.setSuccess(true);
                resultEntity.setErrorMsg(null);
            } else {
                resultEntity.setData(null);
                resultEntity.setSuccess(false);
                resultEntity.setErrorMsg("错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setData(null);
            resultEntity.setSuccess(false);
            resultEntity.setErrorMsg(e.getMessage());
        }
        return resultEntity;
    }

    /**
     * 根据ID删除Todo
     *
     * @param id
     * @return
     */
    @RequestMapping("/todo/delete")
    public @ResponseBody
    ResultEntity deleteTodo(@RequestParam("id") long id) {
        ResultEntity resultEntity = new ResultEntity();
        try {
            mListRepository.delete(id);
            resultEntity.setData(null);
            resultEntity.setSuccess(true);
            resultEntity.setErrorMsg(null);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setData(null);
            resultEntity.setSuccess(false);
            resultEntity.setErrorMsg(e.getMessage());
        }
        return resultEntity;
    }

    /**
     * 修改任务名称
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/todo/change")
    public @ResponseBody
    ResultEntity changeTodo(@RequestParam("id") long id, @RequestParam("name") String name) {
        ResultEntity<ListEntity> resultEntity = new ResultEntity<>();
        try {
            mListRepository.updateTodo(name, id);
            ListEntity listEntity = mListRepository.findOne(id);
            resultEntity.setErrorMsg(null);
            resultEntity.setSuccess(true);
            resultEntity.setData(listEntity);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setErrorMsg(e.getMessage());
            resultEntity.setSuccess(false);
            resultEntity.setData(null);
        }
        return resultEntity;
    }
}
