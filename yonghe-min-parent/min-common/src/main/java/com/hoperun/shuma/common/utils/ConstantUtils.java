package com.hoperun.shuma.common.utils;

/**
 *
 * @author ZC
 * @date 2017/10/9
 */
public class ConstantUtils {

    public static final int PAGES = 1;
    public static final int ROWS = 10;
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    /**
     * 管理员名
     */
    public static final String CRM_ADMIN = "ADMIN";
    /**
     * CRM默认密码
     */
    public static final String CRM_PASSWORD = "chinauff123456";

    public static final String USER_TOKEN = "User-Token";

    public static final String WECHAT = "WECHAT";
    public static final String PAY_SUC = "PAY_SUC";

    /**
     * 枚举类型
     */
    public static class EnumsType {

        /**
         * Commonly used status codes defined for data model.
         */
        public enum Status {
            /**
             * 1 VALID, The data is valid
             */
            VALID(1, "Valid"),
            /**
             * 2 INVALID, The data is invalid
             */
            INVALID(2, "Invalid"),
            /**
             * 3 DELETED, The data is deleted
             */
            DELETED(3, "Deleted"),
            /**
             * 4 CREATED
             */
            CREATED(4, "Created");

            public final int code;
            public final String comments;

            Status(final int statusCode, final String reasonPhrase) {
                this.code = statusCode;
                this.comments = reasonPhrase;
            }

            public int getStatusCode() {
                return code;
            }

            public String getcomments() {
                return comments;
            }

            public static Status fromStatusCode(final int statusCode) {
                for (Status s : Status.values()) {
                    if (s.code == statusCode) {
                        return s;
                    }
                }
                return null;
            }
        }

        public enum IsTrue {
            YES(1, "YES"),
            NOT(0, "NO");
            public final int code;
            public final String comments;

            IsTrue(int code, String comments) {
                this.code = code;
                this.comments = comments;
            }
        }

        /**
         * 交易类型
         */
        public enum ActivityType {
            GROUP_ACTIVITY(1, "GROUP_ACTIVITY"),
            SHARE_ACTIVITY(2, "SHARE_ACTIVITY"),
            LOTTERY_ACTIVITY(3, "LOTTERY_ACTIVITY"),

            TIME_LIMIT_ACTIVITY(4, "TIME_LIMIT_ACTIVITY"),
            TIME_SLOT_ACTIVITY(5, "TIME_SLOT_ACTIVITY"),
            FAVORABLE_ACTIVITY(6, "FAVORABLE_ACTIVITY");
            public final int code;
            public final String comments;

            ActivityType(int code, String comments) {
                this.code = code;
                this.comments = comments;
            }
        }

        /**
         * 卡劵类型
         */
        public enum CouponType{
            //优惠劵
            DISCOUNT_CARD(1, "DISCOUNT"),
            //礼品劵
            GIFT_CARD(2, "GIFT"),
            //代金劵
            CASH_CARD(3, "CASH");
            public final int code;
            public final String comments;

            CouponType(int code, String comments) {
                this.code = code;
                this.comments = comments;
            }
        }

        /**
         * 卡劵类型
         */
        public enum TimeType{
            //表示固定时长（自领取后按天算）
            DATE_TYPE_FIX_TERM(1, "DATE_TYPE_FIX_TERM"),
            //固定日期区间
            DATE_TYPE_FIX_TIME_RANGE (2, "DATE_TYPE_FIX_TIME_RANGE");
            public final int code;
            public final String comments;

            TimeType(int code, String comments) {
                this.code = code;
                this.comments = comments;
            }
        }

        public enum ValidTimeType {
            //自领取后多少天内有效
            VALID_DAY(1, "VALID_DAY"),
            //有效时间段
            VALID_TIME(2, "VALID_TIME");
            public final int code;
            public final String comments;

            ValidTimeType(int code, String comments) {
                this.code = code;
                this.comments = comments;
            }
        }

    }
}
