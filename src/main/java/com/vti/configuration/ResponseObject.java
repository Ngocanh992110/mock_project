package com.vti.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject {
    private Integer status;
    private String message;
    private Object data;

    public ResponseObject(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
