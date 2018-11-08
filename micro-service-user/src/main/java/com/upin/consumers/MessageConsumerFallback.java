package com.upin.consumers;

import com.upin.dtos.CommonResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Created by Leslie on 2018/7/27.
 */
@Component
public class MessageConsumerFallback implements MessageConsumer {

    @Override
    public ResponseEntity<Object> validation(@RequestParam(value = "loginName") String loginName,
                                             @RequestParam(value = "code") String code) {
        return new ResponseEntity<>(new CommonResponseDTO().code(HttpStatus.NOT_FOUND.value()).message("未连接到服务"), HttpStatus.NOT_FOUND);
    }
}
