package com.icooding.tingnishuo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * project_name bsppt-parent
 * class Userinfo
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@Entity
public class Userinfo extends BaseEntity{


    private static final long serialVersionUID = -5178538756338120776L;
    private String wxName;
    private String logo;
    private String openId;
    private BigDecimal balance;


    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
