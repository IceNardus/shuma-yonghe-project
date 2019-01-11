package com.hoperun.shuma.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.ConstantUtils;
import com.hoperun.shuma.common.utils.DateUtils;
import com.hoperun.shuma.common.utils.StringUtil;
import com.hoperun.shuma.module.dao.IMinGroupActivityDao;
import com.hoperun.shuma.module.dao.IMinGroupActivityPrizeDao;
import com.hoperun.shuma.module.dao.IMinGroupActivityRecordDao;
import com.hoperun.shuma.module.dao.IMinOrderDao;
import com.hoperun.shuma.service.IMinGroupActivityService;
import com.hoperun.shuma.vo.ThreadMember;
import com.hoperun.shuma.vo.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 6/12/2018
 * Time: 10:16 AM
 */
@Service
public class MinGroupActivityService implements IMinGroupActivityService {


}
