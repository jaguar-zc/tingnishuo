package com.tingnishuo.entity;

import javax.persistence.*;

/**
 * project_name bsppt-parent
 * class Userinfo
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@Entity
@Table(name = "userinfo")
public class Userinfo {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "wx_name")
    private String wxName;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "encrypted_data")
    private String encryptedData;
    private String balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
