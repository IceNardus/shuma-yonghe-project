package com.hoperun.shuma.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoperun.shuma.common.utils.ConstantUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/8/2019
 * Time: 10:47 AM
 * @author xue_chuan
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "min_group_activity_record")
public class MinGroupActivityRecord implements Serializable{


    private static final long serialVersionUID = 4840851503050025490L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date createTime = new Date();

    private String deleteStatus = ConstantUtils.EnumsType.Status.VALID.getcomments();

    /**
     * 订单
     */
    @Column(columnDefinition = "blob")
    private MinOrder groupOrder;

    /**
     * 活动ID
     */
    private int activeId;

    /**
     * 分享者人数
     */
    private int count;

    /**
     * 活动是否已结束
     */
    private Boolean activityFinish=false;

    /**
     * 活动记录编号
     */
    private String groupNum;

    /**
     * 分组头像
     */
    private String participateImg;

    /**
     * 参与者fromId
     */
    private String participateFromId;

    /**
     * 发起者
     */
    private String initiator;

    /**
     * 参与者
     */
    private String participate;


}
