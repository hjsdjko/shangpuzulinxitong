package com.entity.vo;

import com.entity.ChuzuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商铺出租订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuzu_order")
public class ChuzuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商铺出租id
     */

    @TableField(value = "chuzu_id")
    private Integer chuzuId;


    /**
     * 用户id
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 租赁时间/年
     */

    @TableField(value = "chuzu_order_day")
    private Integer chuzuOrderDay;


    /**
     * 审核
     */

    @TableField(value = "shenhe_types")
    private Integer shenheTypes;


    /**
     * 总价
     */

    @TableField(value = "chuzu_order_money")
    private Double chuzuOrderMoney;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商铺出租id
	 */
    public Integer getChuzuId() {
        return chuzuId;
    }


    /**
	 * 获取：商铺出租id
	 */

    public void setChuzuId(Integer chuzuId) {
        this.chuzuId = chuzuId;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户id
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：租赁时间/年
	 */
    public Integer getChuzuOrderDay() {
        return chuzuOrderDay;
    }


    /**
	 * 获取：租赁时间/年
	 */

    public void setChuzuOrderDay(Integer chuzuOrderDay) {
        this.chuzuOrderDay = chuzuOrderDay;
    }
    /**
	 * 设置：审核
	 */
    public Integer getShenheTypes() {
        return shenheTypes;
    }


    /**
	 * 获取：审核
	 */

    public void setShenheTypes(Integer shenheTypes) {
        this.shenheTypes = shenheTypes;
    }
    /**
	 * 设置：总价
	 */
    public Double getChuzuOrderMoney() {
        return chuzuOrderMoney;
    }


    /**
	 * 获取：总价
	 */

    public void setChuzuOrderMoney(Double chuzuOrderMoney) {
        this.chuzuOrderMoney = chuzuOrderMoney;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
