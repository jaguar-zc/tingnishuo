package com.icooding.tingnishuo.service;

import com.icooding.tingnishuo.controller.reources.PacketCommit;
import com.icooding.tingnishuo.controller.reources.PacketredJson;
import com.icooding.tingnishuo.controller.reources.ResultMsg;
import com.icooding.tingnishuo.entity.PacketRed;

/**
 * Created by jagua on 2018/1/6.
 */
public interface PacketRedService {
    ResultMsg commit(PacketCommit packetCommit);

    ResultMsg packetred(PacketredJson packetredJson);

    PacketRed find(Long id);
}
