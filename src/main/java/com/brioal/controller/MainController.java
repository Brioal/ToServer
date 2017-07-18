package com.brioal.controller;

import com.brioal.model.ListEntity;
import com.brioal.repository.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/16.
 */

@Controller
class MainController {

    @Autowired
    ListRepository mListRepository;

    /**
     * 测试接口
     *
     * @return
     */
    @RequestMapping("/")
    public @ResponseBody
    List<ListEntity> getList() {
        List<ListEntity> list = mListRepository.findAll();
        return list;
    }



}
