package com.upin.domain;

import com.aliyuncs.exceptions.ClientException;
import com.upin.dtos.CommonResponseDTO;
import com.upin.exception.BaseException;
import com.upin.dtos.MessageRequestDTO;

import javax.mail.MessagingException;

/**
 * @Created by Leslie on 2018/7/20.
 */
public interface MessageService {

    CommonResponseDTO messageSend(MessageRequestDTO messageRequest) throws BaseException, ClientException, MessagingException;

    boolean validation(String loginName, String code);
}
