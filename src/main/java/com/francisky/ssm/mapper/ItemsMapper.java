package com.francisky.ssm.mapper;

import com.francisky.ssm.model.Items;
import com.francisky.ssm.model.ItemsQuery;

import java.util.List;

/**
 * Created by admin on 2017/2/25.
 */
public interface ItemsMapper {
    // 商品查询列表
    List<Items> findItemsList(ItemsQuery itemsQueryVo)throws Exception;

    // 根据id查询Items
    Items findItemsById(Integer id) throws Exception;

    // 修改Items信息
    void updateItems(Items items) throws Exception;
}
