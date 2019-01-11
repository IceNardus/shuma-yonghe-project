package com.hoperun.shuma.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoperun.shuma.common.utils.ConstantUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/8/2019
 * Time: 09:36 AM
 * @author xue_chuan
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "min_group_activity")
public class MinGroupActivity implements Serializable {


    private static final long serialVersionUID = -5908975387809163460L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date createTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date updateTime;

    private String deleteStatus = ConstantUtils.EnumsType.Status.VALID.getcomments();

    private String activityName;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date endTime;

    /**
     * 限定时间  单位为分
     */
    private Integer limitedTime;

    /**
     * 限定规则
     */
    private String activityRule;


    /**
     * 上下架
     */
    private Boolean shelf=true;

    /**
     * 要求人数
     */
    private Integer participatePeople;

    /**
     *  宣传图
     */
    private String publicizeImgs;

    /**
     * 是否推荐
     */
    private Boolean top;

    /**
     * 排序
     */
    private Integer sort;

     /**
     * 领取次数(每人参加最多次数)
     */
    private Integer receiveCount;

    /**
     * 限定次数(活动参加最多次数)
     */
    private Integer limitedCount;


    /**
     * 奖品集合
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "active_id")
    private List<MinGroupActivityPrize> prizes = new ArrayList<>();

}
