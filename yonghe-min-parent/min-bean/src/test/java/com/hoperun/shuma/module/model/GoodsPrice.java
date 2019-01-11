package com.hoperun.shuma.module.model;

import java.util.Date;

public class GoodsPrice {
    private Integer id;

    private Integer count;

    private Date createTime;

    private String goodsAttributes;

    private Integer goodsId;

    private String payTypes;

    private Double price;

    private String unit;

    private String goodsNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGoodsAttributes() {
        return goodsAttributes;
    }

    public void setGoodsAttributes(String goodsAttributes) {
        this.goodsAttributes = goodsAttributes == null ? null : goodsAttributes.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getPayTypes() {
        return payTypes;
    }

    public void setPayTypes(String payTypes) {
        this.payTypes = payTypes == null ? null : payTypes.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum == null ? null : goodsNum.trim();
    }
}