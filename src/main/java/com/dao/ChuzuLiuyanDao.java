package com.dao;

import com.entity.ChuzuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzuLiuyanView;

/**
 * 商铺出租留言 Dao 接口
 *
 * @author 
 */
public interface ChuzuLiuyanDao extends BaseMapper<ChuzuLiuyanEntity> {

   List<ChuzuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
