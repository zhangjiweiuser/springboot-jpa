package com.zhang.springboot.springbootjpa.exception;

import com.zhang.springboot.springbootjpa.vo.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public Response dealNullPointerException(NullPointerException nullPointerException) {
        return Response.ERROR("空指针异常");
    }
    @ExceptionHandler(BindException.class)
    public Response dealBindExceptionException(BindException bindException) {

        List<FieldError> fieldErrors = bindException.getFieldErrors();
        for(FieldError fieldError : fieldErrors){
            System.out.println("------------");
            System.out.println(fieldError.toString());
            String name = fieldError.getField();
            System.out.println("name:"+name);
            String message = fieldError.getDefaultMessage();
            System.out.println("message:"+message);

            System.out.println("------------");
        }

//        bindException.getFieldErrors();
//        FieldError fieldError = bindException.getFieldError();
//        String field = fieldError.getField();
//        System.out.println(field);
        return Response.ERROR("空指针异常");
    }

    @ExceptionHandler(Exception.class)
    public Response dealNullPointerException(Exception exception) {
        return Response.SERVICE_EXCEPTION();
    }
}
