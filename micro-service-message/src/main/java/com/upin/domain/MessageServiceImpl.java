package com.upin.domain;

import com.aliyuncs.exceptions.ClientException;
import com.upin.dtos.CommonResponseDTO;
import com.upin.exception.BaseException;
import com.upin.domain.email.EmailService;
import com.upin.domain.sms.SmsService;
import com.upin.dtos.MessageRequestDTO;
import com.upin.redis.ValidateCodeManager;
import com.upin.util.DefaultMatcherUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @Created by Leslie on 2018/7/20.
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final SmsService smsService;
    private final EmailService emailService;
    private final ValidateCodeManager validateCodeManager;

    @Value("${message.enable}")
    private boolean enable = false;

    @Autowired
    public MessageServiceImpl(SmsService smsService, EmailService emailService, ValidateCodeManager validateCodeManager) {
        this.smsService = smsService;
        this.emailService = emailService;
        this.validateCodeManager = validateCodeManager;
    }

    @Override
    public CommonResponseDTO messageSend(MessageRequestDTO messageRequest) throws BaseException, ClientException, MessagingException {
        if (enable) {
            if (MessageTypes.PHONE.equals(messageRequest.getMassageType())) {
                isPhone(messageRequest);
            } else if (MessageTypes.EMAIL.equals(messageRequest.getMassageType())) {
                isEmail(messageRequest);
            }
        } else {
            throw new BaseException("Message服务已关闭！");
        }
        return new CommonResponseDTO().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public boolean validation(String loginName, String code) {
        if (StringUtils.isBlank(loginName)) {
            return false;
        }
        if (StringUtils.isBlank(code)) {
            return false;
        }
        String value = validateCodeManager.getCode(loginName);
        return !StringUtils.isBlank(value) && (code.equals(value));
    }

    private void isPhone(MessageRequestDTO messageRequest) throws BaseException, ClientException {
        if (DefaultMatcherUtils.isPhone(messageRequest.getAccountNo())) {
            smsService.smsSend(messageRequest.getAccountNo(), messageRequest.getMassageType(), messageRequest.getTemplateCode());
        } else {
            throw new BaseException("非法手机号！");
        }
    }

    private void isEmail(MessageRequestDTO messageRequest) throws BaseException, MessagingException {
        if (DefaultMatcherUtils.isEmail(messageRequest.getAccountNo())) {
            emailService.emailSend(messageRequest.getAccountNo(), messageRequest.getMassageType(), messageRequest.getTemplateCode());
        } else {
            throw new BaseException("非法邮箱！");
        }
    }
}
