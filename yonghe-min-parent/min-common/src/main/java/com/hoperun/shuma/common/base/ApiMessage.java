package com.hoperun.shuma.common.base;

import com.hoperun.shuma.common.exception.ApiException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 *
 * @author ZC
 * @date 2017/10/9
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApiMessage {
    private boolean succeed = true;

    private int code = HttpStatus.OK.value();

    private String message;

    private Object data;

//    public ApiMessage(String message) {
//        this.succeed = false;
//        this.message = message;
//    }

    public ApiMessage(HttpStatus status, String message) {
        this.succeed = false;
        this.code = status.value();
        this.message = message;
    }

    public ApiMessage(ApiException apiException) {
        this.succeed = false;
        this.code = apiException.getStatus();
        this.message = apiException.getMessage();
    }

    public ApiMessage(Exception ex) {
        this.succeed = false;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = ex.toString();
    }

    public ApiMessage(Object data) {
        this.data = data;
    }

    public ApiMessage(boolean succeed) {
        this.succeed = succeed;
    }

    public ApiMessage() {
    }
}
