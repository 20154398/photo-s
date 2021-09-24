package com.tangyuan.photo.exception;

import com.tangyuan.photo.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result businessExceptionHandle(BusinessException ex) {
        return Result.fail(ex.getMessage());
    }
}
