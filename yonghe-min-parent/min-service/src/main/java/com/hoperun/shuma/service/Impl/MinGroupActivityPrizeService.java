package com.hoperun.shuma.service.Impl;

import com.hoperun.shuma.module.dao.IMinGroupActivityPrizeDao;
import com.hoperun.shuma.service.IMinGroupActivityPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/12/2018
 * Time: 10:16 AM
 */
@Service
public class MinGroupActivityPrizeService implements IMinGroupActivityPrizeService {
    @Autowired
    IMinGroupActivityPrizeDao dao;
}
