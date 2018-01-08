package com.icooding.tingnishuo.controller;

import com.icooding.tingnishuo.controller.reources.PacketCommit;
import com.icooding.tingnishuo.controller.reources.PacketredJson;
import com.icooding.tingnishuo.controller.reources.ResultMsg;
import com.icooding.tingnishuo.entity.PacketRed;
import com.icooding.tingnishuo.entity.Userinfo;
import com.icooding.tingnishuo.repository.PacketRedRepository;
import com.icooding.tingnishuo.repository.UserinfoRepository;
import com.icooding.tingnishuo.service.PacketRedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * project_name bsppt-parent
 * class UserinfoController
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@RestController
@RequestMapping("/packet")
public class PacketRedController {

    @Autowired
    PacketRedService packetRedService;

    /**
     * 获取一个红包
     * @return
     */
    @RequestMapping(value = "/{id}",method={RequestMethod.GET})
    public PacketRed get(@PathVariable(value = "id") Long id){
        return packetRedService.find(id);
    }


    /**
     * 发送一个红包
     * @param packetCommit
     * @return
     */
    @RequestMapping(value = "/commit",method={RequestMethod.POST})
    public ResultMsg commit(@RequestBody PacketCommit packetCommit){
        return packetRedService.commit(packetCommit);
    }

    /**
     * 提现
     * @return
     */
    @RequestMapping(value = "/packetred",method={RequestMethod.POST})
    public ResultMsg packetred(PacketredJson packetredJson){
        return packetRedService.packetred(packetredJson);
    }








}
