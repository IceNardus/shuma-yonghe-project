package com.hoperun.shuma.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 */
public class CodeUtils {
	public static String code() {
		return System.currentTimeMillis() + "";
	}

	public static String userCode(String mobile) {

		return MD5Util.getMd5Upper16(mobile);
	}

	/**
	 * CRM 会员的唯一编号
	 * 2位注册渠道+8位会员唯一序列号+2位随机（字母数字）=16位
	 */
	public static String memberNo(String userChannel, long i) {
		String memberNo =  String.format("%02d",Integer.parseInt(userChannel)) + String.format("%08d", i) + getRandomString(2);
		return memberNo;
	}

	/**
	 * 卡券种类的唯一编号
	 * 2位卡券来源+8位卡券唯一序列号+2位随机（字母数字）=16位
	 */
	public static String cardId(String cardChannel, int i) {
		String cardId = cardChannel + String.format("%08d", i) + getRandomString(2);
		return cardId;
	}

	/**
	 * 券码编号
	 * "QM"+ yyMMddHHmmssssss+ 4位随机（数字字母） = 24位
	 */
	public static String couponCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date());
		String cardId = "QM" + strDate + getRandomString(4);
		return cardId;
	}
	/*
	 * public static String couponCode() { return "MCC" +
	 * UUID.randomUUID().toString().toUpperCase().replace("-", ""); }
	 */

	/**
	 * 门店编号：S+6位门店唯一序列号=7位
	 */
	public static String storeCode(int i) {
		String storeCode = "S" + String.format("%06d", i);
		return storeCode;
	}

	/**
	 * 
	 * 店员编号：M+6位门店唯一序列号=7位
	 */
	public static String staffCode(int i) {
		String staffCode = "M" + String.format("%06d", i);
		return staffCode;
	}
	/**
	 * 点餐等应用下单时生成的订单号
	 * 临时定义："OD"+ yyMMddHHmmssssss  = 20 位
	 */
	public static String orderNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String orderNo = "OD"+ strDate;
		return orderNo;
	}
	
	
	/**
	 * 会员资产调账申请时生成的记录流水号
	 * "TZ"+ yyMMddHHmmsssss+ 5位随机（数字字母） = 24位
	 */
	public static String transferNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String transferNo = "TZ"+ strDate;
		return transferNo;
	}

	/**
	 * 会员资产调账申请时生成的业务流水号
	 * "TZ"+ yyMMddHHmmsssss+ 6位随机（数字字母） = 24位
	 */
	public static String transferChangeNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date())+getRandomString(6);
		String transferNo = "TZ"+ strDate;
		return transferNo;
	}
	
	
	/**
	 * 会员卡充值时生成的记录流水号
	 * "CZ"+ yyMMddHHmmsssss+ 5位随机（数字字母） = 24位
	 */
	public static String rechargeNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String rechargeNo = "CZ"+ strDate;
		return rechargeNo;
	}
	/**
	 * 会员积分变动时生成的记录流水号
	 * "FB"+ yyMMddHHmmsssss+ 5位随机（数字字母） = 24位
	 */
	public static String integralChangeNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String integralChangeNo = "FB"+ strDate;
		return integralChangeNo;
	}
	/**
	 * 会员余额变动时生成的记录流水号
	 * "JB"+ yyMMddHHmmsssss+ 5位随机（数字字母） = 24位
	 */
	public static String balanceChangeNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String balanceChangeNo = "JB"+ strDate;
		return balanceChangeNo;
	}
	/**
	 * 会员卡余额退金时生成的记录流水号
	 * "TJ"+ yyMMddHHmmsssss+ 5位随机（数字字母） = 24位
	 */
	public static String refundCardNo() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String cancelCardNo = "TJ"+ strDate;
		return cancelCardNo;
	}
	
	public static String TransactionNo() {
		return "OC" + DateUtils.getDatetimeMsDefaultFormat();
	}

	public static String TransRecordOrderNo() {
		return "TR" + DateUtils.getDatetimeMsDefaultFormat();
	}

	public static String MINIScoreOrderNo() {
		return "MINI" + DateUtils.getDatetimeMsDefaultFormat();
	}
	/**
	 * 会员等级编号（预留字段，未使用）
	 * 
	 */
	public static String memberLevelCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date())+getRandomString(2);
		return "LV" + strDate;
	}
	/**
	 * 会员等级版本
	 * 
	 */
	public static String memberLevelVersion() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDate = sfDate.format(new Date())+getRandomString(2);
		return "V." + strDate;
	}
	
	
	/**
	 * 会员充值档位编号（预留字段，未使用）
	 * 
	 */
	public static String rechargeCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date())+getRandomString(2);
		return "RC" + strDate;
	}
	
	/**
	 * 会员升级的业务流水号
	 * 
	 */
	public static String UpgradeLevelChangeId() {
		return "LVCH" + DateUtils.getDatetimeMsDefaultFormat();
	}
	
	/**
	 * 会员升级的终端流水
	 * 
	 */
	public static String UpgradeLevelTicket() {
		return "UPLV" + DateUtils.getDatetimeMsDefaultFormat();
	}
	
	
	/**
	 * 营销活动业务流水号
	 * 
	 */
	public static String ScoreShopCode() {
		return "SC" + DateUtils.getDatetimeMsDefaultFormat();
	}
	
	
	/**
	 * 营销活动业务流水号
	 * 
	 */
	public static String MarketActvityChangeId() {
		return "ACT" + DateUtils.getDatetimeMsDefaultFormat();
	}
	
	/**
	 * 营销活动终端流水
	 * 
	 */
	public static String MarketActvityTicket() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String strDate = sfDate.format(new Date());
		return "MARKET" + strDate;
	}
	
	
	/**
	 * 营销活动终端流水
	 * 
	 */
	public static String MarketActvityCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date());
		return "AC" + strDate;
	}
	
	/**
	 * 小程序消息推送 消息编码
	 */
	public static String MiniMsgPushCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String orderNo = "MGC"+ strDate;
		return orderNo;
	}
	/**
	 * 小程序广告位编码
	 */
	public static String MiniAdsenseCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String orderNo = "MAC"+ strDate;
		return orderNo;
	}
	/**
	 * 互动活动Id
	 */
	public static String InteractionActId() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String orderNo = "IA"+ strDate;
		return orderNo;
	}
	/**
	 *发放互动活动奖品流水号
	 */
	public static String TriggerInteractionActivityPrize() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = sfDate.format(new Date())+getRandomString(5);
		String orderNo = "TP"+ strDate;
		return orderNo;
	}
	
	/**
	 * 互动活动奖品code
	 */
	public static String InteractionPrizeCode() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = sfDate.format(new Date())+getRandomString(4);
		String orderNo = "IAPR"+ strDate;
		return orderNo;
	}
	
	
	public static String getRandomString(int length) {
		// 定义一个字符串（A-Z，a-z，0-9）即62位；
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		// 由Random生成随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 长度为几就循环几次
		for (int i = 0; i < length; ++i) {
			// 产生0-61的数字
			int number = random.nextInt(62);
			// 将产生的数字通过length次承载到sb中
			sb.append(str.charAt(number));
		}
		// 将承载的字符转换成字符串
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println("会员编号：" + memberNo("01", 123));
		System.out.println("卡券编号：" + couponCode());

	}

	//
	// public static void main(String[] args) {
	// //格式化当前时间
	// SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	// String strDate = sfDate.format(new Date());
	// //得到17位时间如：20170411094039080
	// System.out.println("时间17位：" + strDate);
	// //为了防止高并发重复,再获取3个随机数
	// String random = getRandom620(3);
	//
	// //最后得到20位订单编号。
	// System.out.println("订单号20位：" + strDate + random);
	//
	// }
	//
	// /**
	// * 获取6-10 的随机位数数字
	// *
	// * @param length 想要生成的长度
	// * @return result
	// */
	// public static String getRandom620(Integer length) {
	// String result = "";
	// Random rand = new Random();
	// int n = 20;
	// if (null != length && length > 0) {
	// n = length;
	// }
	// int randInt = 0;
	// for (int i = 0; i < n; i++) {
	// randInt = rand.nextInt(10);
	// result += randInt;
	// }
	// return result;
	// }
}
