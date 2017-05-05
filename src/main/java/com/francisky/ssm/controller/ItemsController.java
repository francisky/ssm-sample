package com.francisky.ssm.controller;

import com.francisky.ssm.model.Items;
import com.francisky.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by admin on 2017/2/25.
 */
//使用@Controller来标识它是一个控制器
@Controller
@RequestMapping("")
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //商品查询列表
    @RequestMapping("/")
    //实现 对queryItems方法和url进行映射，一个方法对应一个url
    //一般建议将url和方法写成一样
    public ModelAndView queryItems() throws Exception {
        //调用service查找数据库，查询商品列表
        List<Items> itemsList = itemsService.findItemsList(null);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法,在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        //指定视图
        //下边的路径，如果在视图解析器中配置jsp的路径前缀和后缀，修改为items/itemsList
        //modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        //下边的路径配置就可以不在程序中指定jsp路径的前缀和后缀
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("itemInfo/{id}")
    public String editItem(@PathVariable("id") Integer id, Model model) throws Exception {
        Items items = itemsService.findItemsById(id);
        model.addAttribute("item", items);
        return "items/itemInfo";
    }

    @RequestMapping("addItem")
    public String editItem(Items items) throws Exception {
        itemsService.addItems(items);
        // 转发 -- "forward:/hello"
        // 重定向到 /
        return "redirect:/";
    }
}