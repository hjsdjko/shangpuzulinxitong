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

import com.entity.FangdongEntity;

import com.service.FangdongService;
import com.entity.view.FangdongView;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 房东
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangdong")
public class FangdongController {
    private static final Logger logger = LoggerFactory.getLogger(FangdongController.class);

    @Autowired
    private FangdongService fangdongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = fangdongService.queryPage(params);

        //字典表数据转换
        List<FangdongView> list =(List<FangdongView>)page.getList();
        for(FangdongView c:list){
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
        FangdongEntity fangdong = fangdongService.selectById(id);
        if(fangdong !=null){
            //entity转view
            FangdongView view = new FangdongView();
            BeanUtils.copyProperties( fangdong , view );//把实体数据重构到view中

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
    public R save(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangdong:{}",this.getClass().getName(),fangdong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<FangdongEntity> queryWrapper = new EntityWrapper<FangdongEntity>()
            .eq("username", fangdong.getUsername())
            .or()
            .eq("fangdong_phone", fangdong.getFangdongPhone())
            .or()
            .eq("fangdong_id_number", fangdong.getFangdongIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangdongEntity fangdongEntity = fangdongService.selectOne(queryWrapper);
        if(fangdongEntity==null){
            fangdong.setCreateTime(new Date());
            fangdong.setPassword("123456");
            fangdongService.insert(fangdong);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangdong:{}",this.getClass().getName(),fangdong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<FangdongEntity> queryWrapper = new EntityWrapper<FangdongEntity>()
            .notIn("id",fangdong.getId())
            .andNew()
            .eq("username", fangdong.getUsername())
            .or()
            .eq("fangdong_phone", fangdong.getFangdongPhone())
            .or()
            .eq("fangdong_id_number", fangdong.getFangdongIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangdongEntity fangdongEntity = fangdongService.selectOne(queryWrapper);
        if("".equals(fangdong.getFangdongPhoto()) || "null".equals(fangdong.getFangdongPhoto())){
                fangdong.setFangdongPhoto(null);
        }
        if(fangdongEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fangdong.set
            //  }
            fangdongService.updateById(fangdong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangdongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        FangdongEntity fangdong = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("username", username));
        if(fangdong==null || !fangdong.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(fangdong.getId(),username, "fangdong", "房东");
        R r = R.ok();
        r.put("token", token);
        r.put("role","房东");
        r.put("username",fangdong.getFangdongName());
        r.put("tableName","fangdong");
        r.put("userId",fangdong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody FangdongEntity fangdong){
    //    	ValidatorUtils.validateEntity(user);
        if(fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("username", fangdong.getUsername()).orNew().eq("fangdong_phone",fangdong.getFangdongPhone()).orNew().eq("fangdong_id_number",fangdong.getFangdongIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        fangdong.setCreateTime(new Date());
        fangdongService.insert(fangdong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        FangdongEntity fangdong = new FangdongEntity();
        fangdong.setPassword("123456");
        fangdong.setId(id);
        fangdongService.updateById(fangdong);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrFangdong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        FangdongEntity fangdong = fangdongService.selectById(id);
        return R.ok().put("data", fangdong);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = fangdongService.queryPage(params);

        //字典表数据转换
        List<FangdongView> list =(List<FangdongView>)page.getList();
        for(FangdongView c:list){
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
        FangdongEntity fangdong = fangdongService.selectById(id);
            if(fangdong !=null){
                //entity转view
                FangdongView view = new FangdongView();
                BeanUtils.copyProperties( fangdong , view );//把实体数据重构到view中

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
    public R add(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangdong:{}",this.getClass().getName(),fangdong.toString());
        Wrapper<FangdongEntity> queryWrapper = new EntityWrapper<FangdongEntity>()
            .eq("username", fangdong.getUsername())
            .or()
            .eq("fangdong_phone", fangdong.getFangdongPhone())
            .or()
            .eq("fangdong_id_number", fangdong.getFangdongIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangdongEntity fangdongEntity = fangdongService.selectOne(queryWrapper);
        if(fangdongEntity==null){
            fangdong.setCreateTime(new Date());
        fangdong.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fangdong.set
        //  }
        fangdongService.insert(fangdong);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }





}

