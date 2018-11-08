package com.upin.domain.email;

import com.upin.exception.BaseException;
import com.upin.redis.ValidateCodeManager;
import com.upin.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Created by Leslie on 2018/7/20.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ValidateCodeManager validateCodeManager;

    @Value("${spring.mail.username}")
    private String userName;
    @Value("${code.validate.timeout-minute}")
    private long timeoutMin;

    @Override
    public void emailSend(String recipient, Integer messageType, Integer templateCode) throws BaseException, MessagingException {
        String code = RandomUtils.randomNumSix();
        validateCodeManager.createValidation(recipient, code, timeoutMin);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(userName);
        helper.setTo(recipient);
        helper.setSubject("验证码");
        helper.setText(EmailAgent.getName(templateCode, code));
        javaMailSender.send(mimeMessage);
    }
}
