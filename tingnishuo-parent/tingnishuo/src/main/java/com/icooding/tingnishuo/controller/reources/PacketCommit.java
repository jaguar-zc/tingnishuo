package com.icooding.tingnishuo.controller.reources;

import java.math.BigDecimal;

/**
 * 发一个红包 VO
 * Created by jagua on 2018/1/6.
 */
public class PacketCommit {
    private Long userId;//用户ID
    private String word;//口令
    private Integer count;//数量
    private Integer balance;//金额

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
