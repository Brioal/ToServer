package com.brioal.model;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by Brioal on 2017/7/18.
 */

public class ResultEntity<T> {
    private boolean mIsSuccess = false;//是否失败
    private String errorMsg = null;//错误信息
    private T mData;


    public ResultEntity() {
    }

    public ResultEntity(boolean isSuccess, String errorMsg, T data) {
        mIsSuccess = isSuccess;
        this.errorMsg = errorMsg;
        mData = data;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public boolean isSuccess() {
        return mIsSuccess;
    }

    public void setSuccess(boolean success) {
        mIsSuccess = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
