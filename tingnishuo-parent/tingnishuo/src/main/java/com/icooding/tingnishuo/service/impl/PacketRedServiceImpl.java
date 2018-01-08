package com.icooding.tingnishuo.service.impl;

import com.icooding.tingnishuo.controller.reources.PacketCommit;
import com.icooding.tingnishuo.controller.reources.PacketredJson;
import com.icooding.tingnishuo.controller.reources.ResultMsg;
import com.icooding.tingnishuo.entity.DepositRecord;
import com.icooding.tingnishuo.entity.PacketRed;
import com.icooding.tingnishuo.entity.Userinfo;
import com.icooding.tingnishuo.repository.DepositRecordRepository;
import com.icooding.tingnishuo.repository.PacketRedRepository;
import com.icooding.tingnishuo.repository.UserinfoRepository;
import com.icooding.tingnishuo.service.PacketRedService;
import com.icooding.tingnishuo.utils.HanyuPinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jagua on 2018/1/6.
 */
@Service
public class PacketRedServiceImpl implements PacketRedService {

    HanyuPinyinHelper hanyuPinyinHelper = new HanyuPinyinHelper() ;
    @Autowired
    UserinfoRepository repository;

    @Autowired
    PacketRedRepository packetRedRepository;

    @Autowired
    DepositRecordRepository depositRecordRepository;


    @Override
    public PacketRed find(Long id) {
        return packetRedRepository.findOne(id);
    }

    @Transactional
    @Override
    public ResultMsg commit(PacketCommit packetCommit) {
        Userinfo user = repository.findOne(packetCommit.getUserId());
        if(user == null){
            return new ResultMsg(false,"用户不存在");
        }
        if(user.getBalance().compareTo(BigDecimal.valueOf(packetCommit.getBalance())) == -1){
            return new ResultMsg(false,"余额不足");
        }
        PacketRed packetRed = new PacketRed();
        packetRed.setCreateTime(new Date());
        packetRed.setUpdateTime(new Date());
        packetRed.setStatus(1);
        packetRed.setUserinfoId(user.getId());
        packetRed.setUserinfoLogo(user.getLogo());
        packetRed.setUsername(user.getWxName());
        packetRed.setWord(packetCommit.getWord());
        packetRed.setWordString(hanyuPinyinHelper.toHanyuPinyin(packetCommit.getWord()));
        BigDecimal balance = new BigDecimal(packetCommit.getBalance()*packetCommit.getCount());
        packetRed.setBalance(balance);
        packetRedRepository.save(packetRed);
        user.setBalance(user.getBalance().subtract(balance));
        repository.save(user);
        return new ResultMsg(true,"OK",packetRed.getId());
    }

    @Transactional
    @Override
    public ResultMsg packetred(PacketredJson packetredJson) {
        Userinfo user = repository.findOne(packetredJson.getUserId());
        if(user == null){
            return new ResultMsg(false,"用户不存在");
        }
        if(user.getBalance().compareTo(packetredJson.getBalance()) == -1){
            return new ResultMsg(false,"余额不足");
        }
        user.setBalance(user.getBalance().subtract(packetredJson.getBalance()));
        repository.save(user);
        DepositRecord depositRecord = new DepositRecord();
        depositRecord.setUserinfoId(user.getId());
        depositRecord.setUserinfoLogo(user.getLogo());
        depositRecord.setDepositMoney(packetredJson.getBalance());
        depositRecord.setCreateTime(new Date());
        depositRecord.setUpdateTime(new Date());
        depositRecordRepository.save(depositRecord);
        return new ResultMsg(true,"OK");
    }
}
