package com.tingnishuo.repository;

import com.tingnishuo.entity.Userinfo;
import org.springframework.data.repository.CrudRepository;

/**
 * project_name bsppt-parent
 * class UserinfoRepository
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
public interface UserinfoRepository extends CrudRepository<Userinfo, Long> {


    public Userinfo findByEncryptedData(String encryptedData);
    public Userinfo findByWxName(String wxName);

}
