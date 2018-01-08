package com.icooding.tingnishuo.entity;

/**
 * Created by jagua on 2018/1/6.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 提现
 */
@Entity
public class DepositRecord  extends BaseEntity{
    private static final long serialVersionUID = 7644419190981809839L;

    /**
     * 用户ID
     */
    private Long userinfoId;
    private String userinfoLogo;
    private BigDecimal depositMoney;

    /**
     * 0 发起
     * 1 正在处理
     * 2 提现成功
     * 3 提现失败
     * 提现状态
     */
    private Integer status;


    public Long getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Long userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getUserinfoLogo() {
        return userinfoLogo;
    }

    public void setUserinfoLogo(String userinfoLogo) {
        this.userinfoLogo = userinfoLogo;
    }

    public BigDecimal getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(BigDecimal depositMoney) {
        this.depositMoney = depositMoney;
    }
}
