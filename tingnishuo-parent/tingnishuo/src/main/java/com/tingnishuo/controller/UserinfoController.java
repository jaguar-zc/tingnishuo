package com.tingnishuo.controller;

import com.tingnishuo.entity.Userinfo;
import com.tingnishuo.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(method={RequestMethod.GET})
    public Userinfo get(Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(method={RequestMethod.POST})
    public Long sync(@RequestBody Userinfo userinfo){
        Userinfo byWxName = repository.findByWxName(userinfo.getWxName());
        if(byWxName == null){
            byWxName = repository.save(userinfo);
        }
        return byWxName.getId();
    }

}
