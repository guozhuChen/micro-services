package com.upin.consumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Created by Leslie on 2018/7/27.
 */
@FeignClient(name = "micro-service-message", fallback = MessageConsumerFallback.class)
public interface MessageConsumer {

    @RequestMapping(value = "/message/validation", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
    ResponseEntity<Object> validation(@RequestParam(value = "loginName") String loginName,
                                      @RequestParam(value = "code") String code);
}
