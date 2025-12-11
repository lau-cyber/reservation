package com.cpt202a19.reservation.until;

import java.io.Serializable;

/** Response in Json format */
public class JsonResult<E> implements Serializable {

    private Integer state; // status code
    private String message; // Description
    private E data; // Data
    
    public JsonResult() {
        super();
    }
    
    public JsonResult(Integer state) {
        super();
        this.state = state;
    }
    
    public JsonResult(Throwable e) {
        super();
        this.message = e.getMessage();
    }
    
    public JsonResult(Integer state,E data) {
        super();
        this.state = state;
        this.data = data;
    }
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public E getData() {
        return data;
    }
    
    public void setData(E data) {
        this.data = data;
    }

}
