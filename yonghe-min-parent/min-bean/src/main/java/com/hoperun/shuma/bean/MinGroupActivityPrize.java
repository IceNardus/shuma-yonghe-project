package com.hoperun.shuma.bean;

import com.hoperun.shuma.common.utils.ConstantUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/8/2019
 * Time: 10:27 AM
 * @author xue_chuan
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "min_group_activity_prize")
public class MinGroupActivityPrize implements Serializable {
    private static final long serialVersionUID = -2299898745322950929L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    private String deleteStatus = ConstantUtils.EnumsType.Status.VALID.getcomments();

    /**
     * 奖品cardId
     */
    private String prizeCardId;

    /**
     * 奖品名
     */
    private String prizeName;

    /**
     * 数量
     */
    private Integer count;

}
