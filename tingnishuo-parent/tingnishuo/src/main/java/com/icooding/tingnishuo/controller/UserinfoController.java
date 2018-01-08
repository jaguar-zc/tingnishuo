package com.icooding.tingnishuo.controller;

import com.icooding.tingnishuo.entity.PacketRed;
import com.icooding.tingnishuo.entity.Userinfo;
import com.icooding.tingnishuo.repository.PacketRedRepository;
import com.icooding.tingnishuo.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * project_name bsppt-parent
 * class UserinfoController
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    UserinfoRepository repository;

    @RequestMapping(value = "/{userId}",method={RequestMethod.GET})
    public Userinfo get(@PathVariable(value = "userId") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(method={RequestMethod.POST})
    public Long sync(@RequestBody Userinfo userinfo){
        Userinfo byWxName = repository.findByWxName(userinfo.getWxName());
        if(byWxName == null){
            byWxName = repository.save(userinfo);
        }
        byWxName.setLogo(userinfo.getLogo());
        repository.save(byWxName);
        return byWxName.getId();
    }

}
