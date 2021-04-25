package com.myproject.controller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.myproject.bo.PayMentBO;
import com.myproject.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxq
 * @DESCRIPTION
 * @create 2021/4/19
 */
@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {
    private PayService payService;

    /**
     *  下单支付
     * */
    @GetMapping(value = "/confirm" , produces = {"text/html;charset=UTF-8"})
    public Object pay (@RequestParam(required = false) PayMentBO bo) throws Exception {
        //这个接口其实应该是post方式的，但是我这里图方便，直接以get方式访问，
        //且返回格式是text/html，这样前端页面就能直接显示支付宝返回的html片段
        //真实场景下由post方式请求，返回code、msg、data那种格式的标准结构，让前端拿到data里的
        //html片段之后自行加载
        //由于我这里并没有真正的传参数，所以象征性的new一下，避免空指针
        bo = new PayMentBO();
        return payService.pay(bo);
    }


}
