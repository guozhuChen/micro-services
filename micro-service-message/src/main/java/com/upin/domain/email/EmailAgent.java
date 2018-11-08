package com.upin.domain.email;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by Leslie on 2018/7/20.
 */
public class EmailAgent {

    public static String getName(Integer key, String code){
        String DYNAMIC_CODE = "" ;
        String REGISTER_CODE = "您正在申请U品商城手机号码注册，验证码："+ code +",5分钟内有效！切勿泄露。";
        String MODIFY_PASSWORD_CODE = "您正在修改密码，验证码："+ code +" ,请在5分钟内按页面提示提交验证码，切勿泄露。";

        Map<Integer, String> data = new HashMap<>();
        data.put(0, DYNAMIC_CODE);
        data.put(1, REGISTER_CODE);
        data.put(2, MODIFY_PASSWORD_CODE);
        return data.get(key);
    }

}
