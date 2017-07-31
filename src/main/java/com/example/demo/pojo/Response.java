package com.example.demo.pojo;

import java.io.Serializable;
import com.example.demo.pojo.exception.Error;

/**
 * Created by lijiyang on 2017/7/31.
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6602365878131231511L;
    private Response.Status status;
    private String errorCode;
    private String errorMessage;
    private String extMessage;
    private Long pageIndex;
    private Long pageCount;
    private Long pageSize;
    private Long totalCount;
    private T result;

    public Response() {
        this.status = Response.Status.SUCCEED;
    }

    public Response(Error error) {
        this.status = Response.Status.SUCCEED;
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
        this.status = Response.Status.FAILED;
    }

    public static Response create() {
        return new Response();
    }

    public static Response create(Error error) {
        Response response = new Response();
        response.errorCode = error.getErrorCode();
        response.errorMessage = error.getErrorMessage();
        response.status = Response.Status.FAILED;
        return response;
    }

    public Response result(T result) {
        this.result = result;
        return this;
    }

    public Response page(Page page) {
        this.pageIndex = page.getPageIndex();
        this.pageCount = page.getPageCount();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        return this;
    }

    public Response.Status getStatus() {
        return this.status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getExtMessage() {
        return this.extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPageIndex() {
        return this.pageIndex;
    }

    public Long getPageCount() {
        return this.pageCount;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.getErrorCode() != null) {
            sb.append("ErrorCode : ").append(this.getErrorCode()).append("ErrorMessage : ").append(this.getErrorMessage()).append("ExtMessage : " + this.getExtMessage());
        } else {
            sb.append("Succeed");
        }

        return sb.toString();
    }

    public static enum Status {
        SUCCEED,
        FAILED,
        PROCESSING,
        NO_DATA;

        private Status() {
        }
    }
}
