package com.shuma.bean;

import lombok.Data;

import java.util.List;

/**
 * @author xue_chuan
 */
@Data
public class WxMpCouponRequest {
	List<String> cardIds;
	
	String encryptCode;

	/**
	 * 活动编号
	 */
	String activeNum;

	/**
	 * 活动类型
	 */
	int activeType;

	/**
	 * 活动Id
	 */
	int activeId;
}
