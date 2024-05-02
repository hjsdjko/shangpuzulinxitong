package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChuzuOrderDao;
import com.entity.ChuzuOrderEntity;
import com.service.ChuzuOrderService;
import com.entity.view.ChuzuOrderView;

/**
 * 商铺出租订单 服务实现类
 */
@Service("chuzuOrderService")
@Transactional
public class ChuzuOrderServiceImpl extends ServiceImpl<ChuzuOrderDao, ChuzuOrderEntity> implements ChuzuOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChuzuOrderView> page =new Query<ChuzuOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
