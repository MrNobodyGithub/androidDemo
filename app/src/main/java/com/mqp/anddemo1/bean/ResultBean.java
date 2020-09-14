package com.mqp.anddemo1.bean;

public class ResultBean<T> extends BaseBean  {
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回码
     */
    private int error;
    /**
     * 数据
     */
    private T data;

    public ResultBean() {
    }

    public ResultBean(String message, int error, T data) {
        this.message = message;
        this.error = error;
        this.data = data;
    }

    /**
     * 获取
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     * @return error
     */
    public int getError() {
        return error;
    }

    /**
     * 设置
     * @param error
     */
    public void setError(int error) {
        this.error = error;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "ResultBean{message = " + message + ", error = " + error + ", data = " + data + "}";
    }
}
