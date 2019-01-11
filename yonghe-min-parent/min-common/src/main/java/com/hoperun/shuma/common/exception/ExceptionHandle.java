package com.hoperun.shuma.common.exception;

import com.hoperun.shuma.common.base.ApiMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 5/7/2018
 * Time: 9:40 AM
 * @author xue_chuan
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandle {


    /**
     * 自定义异常
     * @param apiException
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public Object apiException(ApiException apiException) {
        log.error(apiException.getMessage(), apiException);
        log.error("**********************************************************************************************");
        log.error("********************* Status  : "+apiException.getStatus());
        log.error("********************* Message : "+ apiException.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(apiException);
    }



    /**
     *  运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error(runtimeException.getMessage(), runtimeException);
        log.error("**********************************************************************************************");
        log.error("***********************  RuntimeException *******************************************");
        log.error("********************* Message : "+ runtimeException.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.RUNTIME_EXCEPTION));
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object nullPointerExceptionHandler(NullPointerException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  NullPointerException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.NULLPOINTER_EXCEPTION));
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public Object classCastExceptionHandler(ClassCastException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  ClassCastException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.CLASSCAST_EXCEPTION));
    }
    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Object iOExceptionHandler(IOException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  IOException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.CLASSCAST_EXCEPTION));
    }
    /**
     * 未知方法异常
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public Object noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  NoSuchMethodException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.CLASSCAST_EXCEPTION));
    }
    /**
     * 数组越界异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public Object indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  IndexOutOfBoundsException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.CLASSCAST_EXCEPTION));
    }

    /**
     * 数据库异常
     */
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Object sqlExceptionHandler(SQLException ex) {
        log.error(ex.getMessage(), ex);
        log.error("**********************************************************************************************");
        log.error("***********************  SQLException *******************************************");
        log.error("********************* Message : "+ ex.getMessage());
        log.error("**********************************************************************************************");
        return new ApiMessage(new ApiException(ApiResponseStatus.SQL_EXCEPTION));
    }



}
