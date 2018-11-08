package com.upin.exception;

import com.upin.dtos.CommonResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Created by Leslie on 2018/8/25.
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public CommonResponseDTO handle(Exception e) {
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
        if (e instanceof BaseException){
            commonResponseDTO.code(((BaseException) e).getCode()).message(e.getMessage());
        }else {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            commonResponseDTO.code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("服务器异常").detail("[" + e.getClass().getSimpleName()
                    + "]" + e.getMessage() + "\n" +
                    "traces:\n" +
                    errors.toString());
        }
        return commonResponseDTO;
    }
}
