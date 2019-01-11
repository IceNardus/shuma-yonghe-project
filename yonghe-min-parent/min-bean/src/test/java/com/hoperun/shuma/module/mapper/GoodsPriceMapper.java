package com.hoperun.shuma.module.mapper;

import com.hoperun.shuma.module.model.GoodsPrice;

public interface GoodsPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPrice record);

    int insertSelective(GoodsPrice record);

    GoodsPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPrice record);

    int updateByPrimaryKey(GoodsPrice record);
}