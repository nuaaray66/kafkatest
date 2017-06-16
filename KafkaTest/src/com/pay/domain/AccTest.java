package com.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccTest implements Serializable {
    /**
     * ACC_TEST.ID
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private Integer id;

    /**
     * ACC_TEST.CUS_CODE (账户号)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private String cusCode;

    /**
     * ACC_TEST.CUS_NAME (客户名称)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private String cusName;

    /**
     * ACC_TEST.PASSWORD (账户密码)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private String password;

    /**
     * ACC_TEST.ACCOUNT (账户金额)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private BigDecimal account;

    /**
     * ACC_TEST.LAST_PAY_TIME (最后一次支付时间)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private Date lastPayTime;

    /**
     * ACC_TEST.STATUS (账户状态)
     * @ibatorgenerated 2017-06-12 08:40:42
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public Date getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}