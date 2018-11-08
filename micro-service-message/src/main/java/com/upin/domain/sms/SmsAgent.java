package com.upin.domain.sms;

/**
 * @Created by Leslie on 2018/7/18.
 */
public enum SmsAgent {
    DYNAMIC_CODE(0, "SMS_123674854") ,
    REGISTER_CODE(1, "SMS_123669378") ,
    MODIFY_PASSWORD_CODE(2, "SMS_123799192");

    private final int key ;
    private final String value ;

    SmsAgent(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getName(int key){
        for (SmsAgent smsAgent : SmsAgent.values()){
            if (smsAgent.getKey() == key){
                return smsAgent.getValue();
            }
        }
        return null ;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
