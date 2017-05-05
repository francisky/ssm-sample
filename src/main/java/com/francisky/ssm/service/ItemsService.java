package com.francisky.ssm.service;

import com.francisky.ssm.model.Items;
import com.francisky.ssm.model.ItemsQuery;

import java.util.List;

/**
 * Created by admin on 2017/2/25.
 */
public interface ItemsService {
    //商品查询列表
    List<Items> findItemsList(ItemsQuery itemsQueryVo) throws Exception;

    //根据id查询商品信息
    /**
     *
     * <p>Title: findItemsById</p>
     * <p>Description: </p>
     * @param id 查询商品的id
     * @return
     * @throws Exception
     */
    Items findItemsById(Integer id) throws Exception;

    //修改商品信息
    /**
     *
     * <p>Title: updateItems</p>
     * <p>Description: </p>
     * @param items 修改的商品信息,商品的信息中就包含商品id，可以通过id去查询
     * @throws Exception
     */
    void updateItems(Items items) throws Exception;

    void addItems(Items items) throws Exception;
}
