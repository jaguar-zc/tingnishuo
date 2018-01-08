package com.tingnishuo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * project_name bsppt-parent
 * class PacketRed
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@Entity
@Table(name = "packet_red")
public class PacketRed {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "userinfo_id")
    private Long userinfoId;
    private BigDecimal balance;

    private String _key;
    private String _keyString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String get_key() {
        return _key;
    }

    public void set_key(String _key) {
        this._key = _key;
    }

    public String get_keyString() {
        return _keyString;
    }

    public void set_keyString(String _keyString) {
        this._keyString = _keyString;
    }
}
