package com.hoperun.shuma.module.dao.Impl;

import com.hoperun.shuma.module.dao.IMinGroupActivityDao;
import com.hoperun.shuma.module.jpa.MinGroupActivityJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/11/2018
 * Time: 4:08 PM
 */
@Service
public class MinGroupActivityDao implements IMinGroupActivityDao {
    @Autowired
    MinGroupActivityJpa jpa;


}
