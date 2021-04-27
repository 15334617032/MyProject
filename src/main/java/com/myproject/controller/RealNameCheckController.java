package com.myproject.controller;

import com.myproject.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxq
 * @DESCRIPTION 实名认证
 * @create 2021/4/27
 */
@RestController
@RequestMapping("/realName")
public class RealNameCheckController {

    @Value("${realName.appcode}")
    private static String appcode;
    @Value("${realName.host}")
    private static String host;
    @Value("${realName.path}")
    private static String path;
    @Value("${realName.method}")
    private static String method;

    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<>(10);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>(10);
        querys.put("idcard", "500228199508243377");
        querys.put("name", "曾祥强");

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println("返回信息:"+response.toString());
            System.out.println("------------------------------------------------");
            //获取response的body
//            200	成功	成功
//            400	参数错误	参数错误
//            404	资源不存在	资源不存在
//            500	系统内部错误，请联系服务商	系统内部错误，请联系服务商
//            501	第三方服务异常	第三方服务异常
//            604	接口停用	接口停用
//            1001	其他，以实际返回为准	其他，以实际返回为准
//            温馨提示：
//            出现'无记录'时，有以下几种原因
//                    (1)现役军人、武警官兵、特殊部门人员及特殊级别官员；
//            (2)退役不到2年的军人和士兵（根据军衔、兵种不同，时间会有所不同，一般为2年）；
//            (3)户口迁出，且没有在新的迁入地迁入；
//            (4)户口迁入新迁入地，当地公安系统未将迁移信息上报到公安部（上报时间地域不同而有所差异）；
//            (5)更改姓名，当地公安系统未将更改信息上报到公安部（上报时间因地域不同而有所差异）；
//            (6)移民；
//            (7)未更换二代身份证；
//            (8)死亡。
//            {
//                "msg": "成功",
//                    "success": true,
//                    "code": 200,
//                    "data": {
//                "result": 1,//0 一致，1 不一致，2 无记录
//                        "order_no": "626072002058391552",//订单号
//                        "desc": "不一致",//描述
//                        "sex": "男",//性别
//                        "birthday": "19940320",//生日
//                        "address": "江西省南昌市东湖区"//地址
//            }
//            }
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
