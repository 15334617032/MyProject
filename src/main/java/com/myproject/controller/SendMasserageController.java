package com.myproject.controller;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;

import java.util.HashMap;


/**
 * @author zxq
 * @DESCRIPTION
 * @create 2021/4/21
 */
public class SendMasserageController {

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dysmsapi20170525.Client client = createClient("LTAI5tGjFV1P4h1Wef5yX32n", "0Fh8tn8flFceFdmmLcCX3Dt72kYbCV");
        HashMap<String, Object> m = new HashMap<>();
        m.put("code",123456);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("15334617032")
                .setSignName("曾祥强的个人app")
                .setTemplateCode("SMS_215339225")
                .setTemplateParam(JSONObject.toJSONString(m));
        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
    }
}
