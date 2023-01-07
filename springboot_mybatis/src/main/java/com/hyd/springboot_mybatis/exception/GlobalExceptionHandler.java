package com.hyd.springboot_mybatis.exception;

import com.hyd.springboot_mybatis.utils.Constants;
import com.hyd.springboot_mybatis.utils.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hayden
 * @Date: 2023-01-08
 * @Description: 全局异常处理器
 */
@ControllerAdvice
@Order
public class GlobalExceptionHandler {

    private Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    public Object MissingPathVariableHandler(MissingPathVariableException e) {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(Constants.VARIABLE_NULL, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object HttpRequestMethodNotSupportedHandler(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(Constants.VARIABLE_NULL, e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object NullPointerExceptionHandler(NullPointerException e){
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(Constants.VARIABLE_NULL, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object seriousHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseUtil.error(e.getMessage());
    }

}
