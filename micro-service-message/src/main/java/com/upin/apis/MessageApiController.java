package com.upin.apis;

import com.upin.domain.MessageService;
import com.upin.dtos.CommonResponseDTO;
import com.upin.dtos.MessageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Created by Leslie on 2018/7/18.
 */
@RestController
public class MessageApiController implements MessageApi {
    private final MessageService messageService;

    @Autowired
    public MessageApiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public ResponseEntity<Object> messageSend(@NotNull @RequestBody MessageRequestDTO messageRequest) throws Exception {
        CommonResponseDTO response = messageService.messageSend(messageRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> validation(@RequestParam(value = "loginName") String loginName,
                                             @RequestParam(value = "code") String code) throws Exception {
        boolean response = messageService.validation(loginName, code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
