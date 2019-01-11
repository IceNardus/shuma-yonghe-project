package com.hoperun.shuma.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * 自定义异常类
 *
 * @author ZC
 * @date 2017/9/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {
    static final long serialVersionUID = 1L;

    private int status;

    private String message;

    public ApiException(ApiResponseStatus status) {
        this.message = status.getReason();
        this.status = status.getCode();
    }

    public ApiException(HttpStatus status) {
        this.message = status.getReasonPhrase();
        this.status = status.value();
    }

    public ApiException(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

//    public ApiException(ApiResponseStatus status, String message) {
//        super(message);
//        this.status = status;
//    }
}
