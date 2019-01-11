package com.hoperun.shuma.service.Impl;

import com.hoperun.shuma.module.dao.IMinGroupActivityRecordDao;
import com.hoperun.shuma.service.IMinGroupActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/12/2018
 * Time: 10:16 AM
 */
@Service
public class MinGroupActivityRecordService implements IMinGroupActivityRecordService {
    @Autowired
    IMinGroupActivityRecordDao dao;
}
