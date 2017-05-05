package com.francisky.ssm.service.impl;

import com.francisky.ssm.mapper.ItemsMapper;
import com.francisky.ssm.model.Items;
import com.francisky.ssm.model.ItemsQuery;
import com.francisky.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2017/2/25.
 */
public class ItemsServiceImpl implements ItemsService {


    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> findItemsList(ItemsQuery itemsQuery) throws Exception {
        return itemsMapper.findItemsList(itemsQuery);
    }

    public Items findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.findItemsById(id);
        //中间对商品信息进行业务处理
        //....
        //返回ItemsCustom
        Items itemsCustom = new Items();
        //将items的属性值拷贝到itemsCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
    }

    public void updateItems(Items items) throws Exception {

    }
}
