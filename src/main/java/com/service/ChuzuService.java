package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuzuEntity;
import java.util.Map;

/**
 * 商铺出租 服务类
 */
public interface ChuzuService extends IService<ChuzuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}