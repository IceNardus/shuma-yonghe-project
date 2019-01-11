package com.hoperun.shuma.module.dao.Impl;

import com.hoperun.shuma.module.dao.IMinOrderDao;
import com.hoperun.shuma.module.jpa.MinOrderJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/11/2018
 * Time: 4:08 PM
 */
@Service
public class MinOrderDao implements IMinOrderDao {
    @Autowired
    MinOrderJpa jpa;


}
