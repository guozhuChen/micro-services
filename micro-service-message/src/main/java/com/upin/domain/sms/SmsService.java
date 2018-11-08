package com.upin.domain.sms;

import com.aliyuncs.exceptions.ClientException;
import com.upin.exception.BaseException;

/**
 * @Created by Leslie on 2018/7/18.
 */
public interface SmsService {

    void smsSend(String phone, Integer messageType, Integer templateCode) throws BaseException, ClientException;
}
