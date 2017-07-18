package com.brioal.repository;

import com.brioal.model.ClassifyEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */
@Repository
public interface ClassifyRepository extends JpaRepository<ClassifyEntity, Long> {


    /**
     * 根据用户ID返回所有的分类
     *
     * @param userID
     * @return
     */
    List<ClassifyEntity> findAllByUseridEquals(long userID);

    /**
     * 更新分类
     * @param title
     * @param id
     */
    @Modifying
    @Transactional
    @Query("update ClassifyEntity clasify set clasify.name=:qName where clasify.id=:qId")
    void updateBlog(@Param("qName") String title, @Param("qId") long id);
}
