package com.brioal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */

@Entity
@Table(name = "user", schema = "todo", catalog = "")
public class UserEntity {
    private long mUserid;
    private String mUsername;
    private String mPassword;
    private String mEmail;

    @Id
    @Column(name = "userid", nullable = false)
    public long getUserid() {
        return mUserid;
    }

    public void setUserid(long userid) {
        mUserid = userid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (mUserid != that.mUserid) return false;
        if (mUsername != null ? !mUsername.equals(that.mUsername) : that.mUsername != null)
            return false;
        if (mPassword != null ? !mPassword.equals(that.mPassword) : that.mPassword != null)
            return false;
        if (mEmail != null ? !mEmail.equals(that.mEmail) : that.mEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mUserid ^ (mUserid >>> 32));
        result = 31 * result + (mUsername != null ? mUsername.hashCode() : 0);
        result = 31 * result + (mPassword != null ? mPassword.hashCode() : 0);
        result = 31 * result + (mEmail != null ? mEmail.hashCode() : 0);
        return result;
    }
}
