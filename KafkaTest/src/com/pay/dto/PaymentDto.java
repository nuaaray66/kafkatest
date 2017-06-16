package com.pay.dto;


import java.math.BigDecimal;
import java.util.Date;

public class PaymentDto{
    /**
     * PAYMENT.ID (支付主键)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Integer id;

    /**
     * PAYMENT.PAY_NUM (支付流水号)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String payNum;

    /**
     * PAYMENT.PAY_CUS (支付账号)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String payCus;

    /**
     * PAYMENT.PAY_ACCOUNT
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private BigDecimal payAccount;

    /**
     * PAYMENT.RESULT (支付结果；
0：未处理
1：等待处理结果
2：支付处理完成)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String result;

    /**
     * PAYMENT.BEGIN_TIME (支付开始处理时间)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Date beginTime;

    /**
     * PAYMENT.END_TIME (支付处理完成时间)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Date endTime;

    /**
     * PAYMENT.FLAG (重复处理状态；
0：未处理
1： 处理中
2:  处理完成)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public String getPayCus() {
        return payCus;
    }

    public void setPayCus(String payCus) {
        this.payCus = payCus;
    }

    public BigDecimal getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(BigDecimal payAccount) {
        this.payAccount = payAccount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}