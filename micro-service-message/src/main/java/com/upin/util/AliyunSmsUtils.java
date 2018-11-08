package com.upin.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @Created by Leslie on 2018/7/18.
 */
public class AliyunSmsUtils {
    private String product ;
    private String domain ;
    private String regionId ;
    private String endPointName ;
    private String accessKeyId ;
    private String accessKeySecret ;

    public AliyunSmsUtils(String product, String domain, String regionId, String endPointName, String accessKeyId, String accessKeySecret) {
        this.product = product;
        this.domain = domain;
        this.regionId = regionId;
        this.endPointName = endPointName;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    public SendSmsResponse sendSms(String phone, String signName, String templateCode, String paramTemplateJson, String outId) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(endPointName, regionId, product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);

        request.setTemplateParam(paramTemplateJson);
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        if (outId!=null){
            request.setOutId(outId);
        }
        //此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

}
