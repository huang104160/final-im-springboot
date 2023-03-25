package com.test.im.exception;



import com.test.im.utils.ResponseUtils;
import com.test.im.utils.TokenExcption;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        if (e instanceof TokenExcption){
            return ResponseUtils.unlogin();
        }else if (e instanceof MalformedJwtException) {
            return ResponseUtils.unlogin();
        }else if (e instanceof ExpiredJwtException){
            return ResponseUtils.unlogin();
        }else {
            return ResponseUtils.fail();
        }
    }

}