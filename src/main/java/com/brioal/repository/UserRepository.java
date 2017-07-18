package com.brioal.repository;

import com.brioal.model.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 根据UserName登陆
     *
     * @param username
     * @param password
     * @return
     */
    UserEntity findUserEntityByUsernameEqualsAndPasswordEquals(String username, String password);

    /**
     * 根据Email查询
     *
     * @param email
     * @param password
     * @return
     */
    UserEntity findUserEntityByEmailEqualsAndPasswordEquals(String email, String password);
}
