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
@Table(name = "classify", schema = "todo", catalog = "")
public class ClassifyEntity {
    private long mId;
    private String mName;
    private long mUserid;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public long getUserid() {
        return mUserid;
    }

    public void setUserid(long userid) {
        mUserid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassifyEntity that = (ClassifyEntity) o;

        if (mId != that.mId) return false;
        if (mUserid != that.mUserid) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mId ^ (mId >>> 32));
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (int) (mUserid ^ (mUserid >>> 32));
        return result;
    }
}
