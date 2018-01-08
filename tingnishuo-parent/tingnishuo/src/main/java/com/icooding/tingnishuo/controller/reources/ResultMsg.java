package com.icooding.tingnishuo.controller.reources;

/**
 * Created by jagua on 2018/1/7.
 */
public class ResultMsg {
    private Boolean success;
    private String message;
    private Object data;

    public ResultMsg(Boolean success) {
        this.success = success;
    }

    public ResultMsg(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultMsg(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
