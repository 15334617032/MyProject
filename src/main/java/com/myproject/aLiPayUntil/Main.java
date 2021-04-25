package com.myproject.aLiPayUntil;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;

/**
 * @author zxq
 * @DESCRIPTION
 * @create 2021/4/19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .preCreate("Apple iPhone11 128G", "2234567890", "0.10");
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";

        config.appId = "2021000117641604";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEvzN1kUeyr36WOiUcVop9ONmQZOoldnLgCbAcUtqnVIs2j1UAUrX4teF47thXbf6ncBVIrRKxwy/eAkZJanVj9ZOWMxyBMyo6vdp0aL4y+SiMRvomfR5rzCwsdxnjGOOcOmFsI+52/YeuejY0Ww8y8Wyw/Ia7Uler90spzWBv99wKupWO+KF+uhmsjh/NSd5wabJSk5QJc59skdBRFfw6CR7cUH87hrm8pHqrOpR8+FV0zrIY8CGE6Ig2GYh0hDLnkXrOtflgq32twC+lMlWUHzjXWGAJNqQsvhxx4lwSdZ1NNgZoEaS/E5eZa0kPg8kJPVLNBfRsSJgtIqMevwX/AgMBAAECggEANb3Cc4JRaIGr2d3IUGSoxHFTgyWXtXrynsjNR2ozozKS+Y+ldfAGQ54+ndr0MtERG3BA7Z9DxjujEVoSYn567/DnwxMGIzg3jHh4DFCrT6+XPtMtSo+01SdfatD85feZjhIEhuc1D28skvJfJ2sGCDW9LxnM4eFAJRqEj3PZ6vnz6NJMMNwz7zK3kSd5+deJWsizDukjlcVu9HvCQW/KiZx5WSKa71x0DZ68SCzGcidfqUZAiRo9K3Sc89aWT2WK3eGhT2u5kdTE9AubJ9+2LrpMcQOonTQX0iqu7NyVqx47PMJDz3bpgk2E9PU2mA6xOj+ElV3aEGb5anz3GZ9aAQKBgQDBUcuh6fUI5FmhAYmOcBoYJxBdGsjVKCw4wm9xjod7uEP23ZokXAo3hWuLdT9L5emPQ2RyQ07toiKQp2v3hZpzicZFiaLjOHPgSDC4KTOwq7lz4gRgxmjE3uQufFDZVrqp7NVoRtMje9r+p+7cRxoqk/0y3XV8TfpitxHW2PmewQKBgQCvyamMX2xzZ0BpMVZb29crHNRHSffgqTqyQOX7NlJVMJ1WGbDL7+UlJLVidzxAiLiwppv7EImPiEomj8NZ/lo61khDbIwSb92LyiIilKER/feqhwXdhUvf8DwG+R+1X2mIA+O4FmlMGw2cH25/GmoR2QLY6aLEyOKM03E7NTqUvwKBgBoMqpLb0r/q/UTbzyxZYLrGcMcK9+r5KdRQJvI3UXxTXR0jyUSC/oFywgYdu3S/u1QpsZxQA4+z3FJ/rOXCpAhTlVsDa+aQUdT0BVSbgLKawTejShG8SpvUqQy2hbJzpF2HY05U1NigNOdBu8cE8bqxDFpRSyZ/33Bz2LyJqkFBAoGAG+tys2nghr/Keiqs5bAYD6/ng18bMKKQQQmPvYOWNhOfmbJA41M52NloubfoaPOOKfh8Y7bvsk1aQZ+pzlxYpmmsVpEh+jesP2yeWVGz93CX6ozBgLqQH4Q/dHgS8jKyRzke7PkaRk0xry9K1IM0f5sxGZSaFpk1alqW7Gl64W8CgYB2+EXsQhRhHhkHhxwGGnmqiRSebYY9Oy+zgett0gM7MGILGMrTmmYc09jx5boLrwdRG989OzfzEYTBRkPWsrWaaq4EmNl48BlRkK8HcMHgEUcXFBsUPUna+AtyELy4omUH5aLvlc39dIscJ5dTALjplPN9ls0RUvqr/LGDtXeruA==";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0uT9xjrb1LJKQRMGHb6QzD9gsI3pymmUoQWoCuUbtyCacij8QKYlUlDTu8lsMQahPHt77mwziUcxXnFujA6KQbB+O9ShDMJZ1z9BtfsNxF2E0cNPBn3vUF3YAVcLhydYMWcSqNsz4jZoQBkXVVqJUPBE3v2NUqxJokmHPTns1SmTnQQOq42CtAkNnFHIy5gdlN48INbGXqE6McBKbvtnxeyifZ3nroWxlnTL2npah8rKRN20GdIIvzML4F2BeLoG28q91rnBHa6zfEQVDobdGEBLTZw45tpD26aZiJHj0KXBydID8KuRtyxngRWppqG4OIcJ0OpfnAIwHSOj8I2ccwIDAQAB";

        //可设置异步通知接收服务地址（可选）
//        config.notifyUrl = "<-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = "+NQTMCludGa1ozbRGud0BQ==";

        return config;
    }
}
