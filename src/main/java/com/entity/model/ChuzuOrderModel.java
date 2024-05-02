package com.entity.model;

import com.entity.ChuzuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商铺出租订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuzuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商铺出租id
     */
    private Integer chuzuId;


    /**
     * 用户id
     */
    private Integer yonghuId;


    /**
     * 租赁时间/年
     */
    private Integer chuzuOrderDay;


    /**
     * 审核
     */
    private Integer shenheTypes;


    /**
     * 总价
     */
    private Double chuzuOrderMoney;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商铺出租id
	 */
    public Integer getChuzuId() {
        return chuzuId;
    }


    /**
	 * 设置：商铺出租id
	 */
    public void setChuzuId(Integer chuzuId) {
        this.chuzuId = chuzuId;
    }
    /**
	 * 获取：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户id
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：租赁时间/年
	 */
    public Integer getChuzuOrderDay() {
        return chuzuOrderDay;
    }


    /**
	 * 设置：租赁时间/年
	 */
    public void setChuzuOrderDay(Integer chuzuOrderDay) {
        this.chuzuOrderDay = chuzuOrderDay;
    }
    /**
	 * 获取：审核
	 */
    public Integer getShenheTypes() {
        return shenheTypes;
    }


    /**
	 * 设置：审核
	 */
    public void setShenheTypes(Integer shenheTypes) {
        this.shenheTypes = shenheTypes;
    }
    /**
	 * 获取：总价
	 */
    public Double getChuzuOrderMoney() {
        return chuzuOrderMoney;
    }


    /**
	 * 设置：总价
	 */
    public void setChuzuOrderMoney(Double chuzuOrderMoney) {
        this.chuzuOrderMoney = chuzuOrderMoney;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
