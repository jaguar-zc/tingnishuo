package com.icooding.tingnishuo.repository;

import com.icooding.tingnishuo.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * project_name bsppt-parent
 * class UserinfoRepository
 * date  2018/1/5
 * author ibm
 * version 1.0
 */
public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
    public Userinfo findByWxName(String wxName);

}
