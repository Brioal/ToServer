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
@Table(name = "list", schema = "todo", catalog = "")
public class ListEntity {
    private long mId;
    private long mClassifyid;
    private String mDetail;
    private Long mUserid;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    @Basic
    @Column(name = "classifyid", nullable = false)
    public long getClassifyid() {
        return mClassifyid;
    }

    public void setClassifyid(long classifyid) {
        mClassifyid = classifyid;
    }

    @Basic
    @Column(name = "detail", nullable = false, length = 100)
    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Long getUserid() {
        return mUserid;
    }

    public void setUserid(Long userid) {
        mUserid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListEntity entity = (ListEntity) o;

        if (mId != entity.mId) return false;
        if (mClassifyid != entity.mClassifyid) return false;
        if (mDetail != null ? !mDetail.equals(entity.mDetail) : entity.mDetail != null)
            return false;
        if (mUserid != null ? !mUserid.equals(entity.mUserid) : entity.mUserid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mId ^ (mId >>> 32));
        result = 31 * result + (int) (mClassifyid ^ (mClassifyid >>> 32));
        result = 31 * result + (mDetail != null ? mDetail.hashCode() : 0);
        result = 31 * result + (mUserid != null ? mUserid.hashCode() : 0);
        return result;
    }
}
