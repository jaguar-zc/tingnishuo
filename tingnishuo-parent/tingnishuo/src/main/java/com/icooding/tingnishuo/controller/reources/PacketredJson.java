package com.icooding.tingnishuo.controller.reources;

import java.math.BigDecimal;

/**
 * Created by jagua on 2018/1/6.
 */
public class PacketredJson {
    private Long userId;//用户ID
    private BigDecimal balance;//金额

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
