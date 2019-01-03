package com.sys.gateway.vo;

public class ErrorInfo {
    private Integer id;
    private String errorCode;
    private String errorMessage;
    private String createTime;

    public ErrorInfo(){}

    public ErrorInfo(String errorCode, String errorMessage, String createTime){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.createTime = createTime;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
