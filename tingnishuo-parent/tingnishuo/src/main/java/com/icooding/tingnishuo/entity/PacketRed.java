package com.icooding.tingnishuo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 代表一个红包
 * project_name bsppt-parent
 * class PacketRed
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@Entity
public class PacketRed extends BaseEntity{
    private static final long serialVersionUID = 7203338589511169154L;
    /**
     * 用户ID
     */
    private Long userinfoId;

    private String userinfoLogo;

    private String username;
    /**
     * 红包总金额
     */
    private BigDecimal balance;

    /**
     * 口令
     */
    private String word;
    /**
     * 口令拼音
     */
    private String wordString;

    /**
     * 小程序码地址
     */
    private String wordcode;

    /**
     * 0 已过期
     * 1 未领完
     * 2 已领完
     */
    private Integer status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Long userinfoId) {
        this.userinfoId = userinfoId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUserinfoLogo() {
        return userinfoLogo;
    }

    public void setUserinfoLogo(String userinfoLogo) {
        this.userinfoLogo = userinfoLogo;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordString() {
        return wordString;
    }

    public void setWordString(String wordString) {
        this.wordString = wordString;
    }

    public String getWordcode() {
        return wordcode;
    }

    public void setWordcode(String wordcode) {
        this.wordcode = wordcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
