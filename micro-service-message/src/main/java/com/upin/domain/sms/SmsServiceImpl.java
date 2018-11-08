package com.upin.domain.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.upin.exception.BaseException;
import com.upin.redis.ValidateCodeManager;
import com.upin.util.AliyunSmsUtils;
import com.upin.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by Leslie on 2018/7/18.
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Value("${aliyun.sms.product}")
    private String product;
    @Value("${aliyun.sms.domain}")
    private String domain;
    @Value("${aliyun.sms.region-id}")
    private String regionId;
    @Value("${aliyun.sms.end-point-name}")
    private String endPointName;
    @Value("${aliyun.sms.access-key-id}")
    private String accessKeyId;
    @Value("${aliyun.sms.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.sms.sign-name}")
    private String signName;

    @Value("${code.validate.timeout-minute}")
    private long timeoutMin;

    @Autowired
    private ValidateCodeManager validateCodeManager;

    @Override
    public void smsSend(String phone, Integer messageType, Integer templateCode) throws BaseException, ClientException {
        String code = RandomUtils.randomNumSix();
        validateCodeManager.createValidation(phone, code, timeoutMin);
        AliyunSmsUtils aliyunSmsUtils = new AliyunSmsUtils(product, domain, regionId, endPointName, accessKeyId, accessKeySecret);
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        String paramTemplateJson = JSON.toJSONString(params);
        aliyunSmsUtils.sendSms(phone, signName, SmsAgent.getName(templateCode), paramTemplateJson, null);
    }
}
