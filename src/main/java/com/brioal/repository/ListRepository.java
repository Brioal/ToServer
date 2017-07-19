package com.brioal.repository;

import com.brioal.model.ListEntity;

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
 * Created by Brioal on 2017/7/16.
 */
@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {
    /**
     * 更新Todo
     *
     * @param title
     * @param id
     */
    @Modifying
    @Transactional
    @Query("update ListEntity todo set todo.detail=:qName where todo.id=:qId")
    void updateTodo(@Param("qName") String title, @Param("qId") long id);

    /**
     * 获取所有的TOdo
     * @param userID
     * @return
     */
    public List<ListEntity> findAllByUserid(long userID);
}
