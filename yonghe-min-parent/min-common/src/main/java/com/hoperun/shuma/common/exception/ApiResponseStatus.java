package com.hoperun.shuma.common.exception;

/**
 * Created by ZC on 2017/9/27.
 */
public enum ApiResponseStatus {

    MEMBER_ALREADY_EXISTED(-102, "会员手机号已经存在"),
    MEMBER_NOT_EXISTED(-103, "会员不存在"),
    MEMBER_ALREADY_FREEZE(-104, "会员已经冻结"),
    MEMBER_REGISTER_FAIL(-105, "会员注册失败"),
    MEMBER_BINDING_FAIL(-106, "会员绑定失败"),
    INVENTORY_NOT_ENOUGH(-201, "库存不够"),
    PARAMETER_ERROR(-202, "参数错误"),
    SCORE_ERROR(-203, "积分错误"),
    BALANCE_ERROR(-204, "余额错误"),
    TIME_NOT_START(-205, "时间未开始"),
    TIME_OVER(-206, "时间已结束"),
    ACTIVITY_TIME_ERROR(-207, "活动时间错误"),
    TOKEN_IS_EMPTY(-208, "TOKEN 缺失"),
    TOKEN_IS_INVALID(-209, "TOKEN 失效"),
    ADD_DATA_FAIL(-210, "添加数据失败"),
    SCORE_LACKING(-211, "积分不足!"),
    LEVEL_LACKING(-212, "等级不足!"),
    RECHARGE_FAIL(-213, "充值失败!"),
    COUPON_NOT_EXISTED_OR_ALREADY_CANCEL(-311, "该券不存在或已核销"),
    COUPON_SEND_FAIL(-312, "发劵失败！"),
    COUPON_ALREADY_RECEIVE(-313, "卡劵已达到领取次数！"),
    COUPON_STOCK_NOT_ENOUGH(-314, "卡券库存不足"),
    SYS_BRAND_ERROR(-300, "品牌信息不存在"),
    NO_SYS_BRAND(-301, "品牌参数为空"),
    SYS_BRAND_TABLE_ALREADY_EXISTED(-302, "品牌表已经存在"),
    SYS_BRAND_MISMATCH(-303, "品牌信息不匹配"),
    ACTIVITY_NO_EXISTED(-320, "暂无活动"),
    ACTIVITY_PRIZE_NO_EXISTED(-321, "活动奖品未设置"),
    ACTIVITY_ALREADY_PARTAKE(-322, "超出活动参加次数"),
    ACTIVITY_ALREADY_FINISH(-323, "活动已经结束"),
    ACTIVITY_PARTAKE_FAIL(-324, "活动参与失败"),
    ACTIVITY_LEVEL_ACHIEVE(-325, "未达到活动要求等级"),
    NO_ACHIEVE_NEWCOMER(-326, "未达到新人活动要求"),
    ACTIVITY_NAME_ALREADY_EXISTED(-327, "活动名称重复"),
    ACTIVITY_PRIZE_ERROR(-329, "活动奖品未达到要求"),
    GROUP_NAME_ALREADY_EXISTED(-331, "群组名称重复"),
    ACTIVITY_PRIZE_NO_MATCh(-330, "活动奖品不匹配"),
    SYS_CONFIG_ERROR(-401, "配置信息不存在错误"),
    ENTITY_DATA_IS_NULL(-402, "实体数据不存在"),
    WECHAT_DECRYPTION_FAIL(-410,"微信解密失败"),
    RUNTIME_EXCEPTION(-501,"[服务器]运行时异常"),
    NULLPOINTER_EXCEPTION(-502,"[服务器]空值异常"),
    CLASSCAST_EXCEPTION(-503,"[服务器]数据类型转换异常"),
    IO_EXCEPTION(-504,"[服务器]IO异常"),
    NOSUCHMETHOD_EXCEPTION(-505,"[服务器]未知方法异常"),
    INDEXOUT_EXCEPTION(-506,"[服务器]数组越界异常"),
    HTTP_EXCEPTION(-507,"[服务器]网络异常"),
    SQL_EXCEPTION(-508,"[服务器]数据库异常"),


    NO_PARAMETER(-101,"参数缺失"),
    NO_FILE(-102,"文件为空"),
    NO_DATA(-201,"查询数据不存在"),
    FAIL_ADD_DATA(-202,"添加数据失败"),
    FAIL_UPDATE_DATA(-203,"修改数据失败"),
    FAIL_DETELE_DATA(-204,"删除数据失败"),
    NO_USER(-301,"用户不存在"),
    NOT_USER_MATCH(-302,"用户名和密码不匹配"),
    NO_USER_LOGIN(-303,"用户未登陆"),
    NO_USER_AUTH(-304,"无操作权限"),
    FAIL_FILE_UPLOAD(-401,"上传文件失败"),
    NOT_DATE_TIME(-402,"数据不在有效期内"),
    NO_DATA_STOCK(-403,"库存不足"),
    FAIL_EXT_USER(-404,"获取外部用户信息失败"),
    FAIL_EXT_USE(-405,"调用外部接口失败"),
    FAIL_WECHAT_USER(-406,"获取微信用户信息失败"),
    FAIL_WECHAT_AUTH(-407,"获取微信授权失败"),
    FAIL_WECHAT_PAY(-408,"微信支付失败")
    ;



    private final int code;
    private final String reason;

    ApiResponseStatus(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
