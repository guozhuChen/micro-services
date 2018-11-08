package com.upin.apis;

import com.upin.dtos.MessageRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * @Created by Leslie on 2018/7/18.
 */
@RequestMapping(value = "/message")
public interface MessageApi {

    @RequestMapping(value = "/send", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    ResponseEntity<Object> messageSend(@NotNull @RequestBody MessageRequestDTO messageRequestDTO) throws Exception;

    @RequestMapping(value = "/validation", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
    ResponseEntity<Object> validation(@RequestParam(value = "loginName") String loginName,
                                      @RequestParam(value = "code") String code) throws Exception;
}
