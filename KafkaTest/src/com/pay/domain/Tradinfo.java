package com.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Tradinfo implements Serializable {
    /**
     * TRADINFO.ID (主键)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Integer id;

    /**
     * TRADINFO.TRAD_NUM (交易流水号)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String tradNum;

    /**
     * TRADINFO.TRAD_CUS (交易客户号)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String tradCus;

    /**
     * TRADINFO.PROD_ID (购买商品编码)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private String prodId;

    /**
     * TRADINFO.TRAD_ACCOUNT (交易金额)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private BigDecimal tradAccount;

    /**
     * TRADINFO.TRAD_TIME (交易时间)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Date tradTime;

    /**
     * TRADINFO.FLAG (交易处理状态；0: 未处理；1:处理完成)
     * @ibatorgenerated 2017-06-12 08:40:41
     */
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradNum() {
        return tradNum;
    }

    public void setTradNum(String tradNum) {
        this.tradNum = tradNum;
    }

    public String getTradCus() {
        return tradCus;
    }

    public void setTradCus(String tradCus) {
        this.tradCus = tradCus;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getTradAccount() {
        return tradAccount;
    }

    public void setTradAccount(BigDecimal tradAccount) {
        this.tradAccount = tradAccount;
    }

    public Date getTradTime() {
        return tradTime;
    }

    public void setTradTime(Date tradTime) {
        this.tradTime = tradTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}