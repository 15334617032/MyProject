package com.myproject.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zxq
 * @DESCRIPTION
 * @create 2021/4/19
 */
@Data
public class PayMentBO {
//省略其他的业务参数，如商品id、购买数量等

    //商品名称
    private String subject;

    //总金额
    private BigDecimal total = BigDecimal.ZERO;

}
