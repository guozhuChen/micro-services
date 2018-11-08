package com.upin.domain.email;

import com.upin.exception.BaseException;

import javax.mail.MessagingException;

/**
 * @Created by Leslie on 2018/7/20.
 */
public interface EmailService {

    void emailSend(String recipient, Integer messageType, Integer templateCode) throws BaseException, MessagingException;
}
