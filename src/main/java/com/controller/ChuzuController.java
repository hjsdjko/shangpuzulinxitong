package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ChuzuEntity;

import com.service.ChuzuService;
import com.entity.view.ChuzuView;
import com.service.FangdongService;
import com.entity.FangdongEntity;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 商铺出租
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuzu")
public class ChuzuController {
    private static final Logger logger = LoggerFactory.getLogger(ChuzuController.class);

    @Autowired
    private ChuzuService chuzuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private FangdongService fangdongService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        else if("房东".equals(role)){
            params.put("fangdongId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = chuzuService.queryPage(params);

        //字典表数据转换
        List<ChuzuView> list =(List<ChuzuView>)page.getList();
        for(ChuzuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuzuEntity chuzu = chuzuService.selectById(id);
        if(chuzu !=null){
            //entity转view
            ChuzuView view = new ChuzuView();
            BeanUtils.copyProperties( chuzu , view );//把实体数据重构到view中

            //级联表
            FangdongEntity fangdong = fangdongService.selectById(chuzu.getFangdongId());
            if(fangdong != null){
                BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setFangdongId(fangdong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("房东".equals(role)){
            chuzu.setFangdongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("huixing_types", chuzu.getHuixingTypes())
            .eq("chuzu_weizhi", chuzu.getChuzuWeizhi())
            .eq("fangdong_id", chuzu.getFangdongId())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if(chuzuEntity==null){
            chuzu.setInsertTime(new Date());
            chuzu.setCreateTime(new Date());
            chuzuService.insert(chuzu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("房东".equals(role)){
            chuzu.setFangdongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        //根据字段查询是否有相同数据
        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .notIn("id",chuzu.getId())
            .andNew()
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("huixing_types", chuzu.getHuixingTypes())
            .eq("chuzu_weizhi", chuzu.getChuzuWeizhi())
            .eq("fangdong_id", chuzu.getFangdongId())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if("".equals(chuzu.getChuzuPhoto()) || "null".equals(chuzu.getChuzuPhoto())){
                chuzu.setChuzuPhoto(null);
        }
        if(chuzuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuzu.set
            //  }
            chuzuService.updateById(chuzu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chuzuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        else if("房东".equals(role)){
            params.put("fangdongId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chuzuService.queryPage(params);

        //字典表数据转换
        List<ChuzuView> list =(List<ChuzuView>)page.getList();
        for(ChuzuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuzuEntity chuzu = chuzuService.selectById(id);
            if(chuzu !=null){
                //entity转view
                ChuzuView view = new ChuzuView();
                BeanUtils.copyProperties( chuzu , view );//把实体数据重构到view中

                //级联表
                    FangdongEntity fangdong = fangdongService.selectById(chuzu.getFangdongId());
                if(fangdong != null){
                    BeanUtils.copyProperties( fangdong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangdongId(fangdong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());
        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("huixing_types", chuzu.getHuixingTypes())
            .eq("chuzu_weizhi", chuzu.getChuzuWeizhi())
            .eq("fangdong_id", chuzu.getFangdongId())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if(chuzuEntity==null){
            chuzu.setInsertTime(new Date());
            chuzu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuzu.set
        //  }
        chuzuService.insert(chuzu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

