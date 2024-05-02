package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 商铺出租订单
 *
 * @author 
 * @email
 */
@TableName("chuzu_order")
public class ChuzuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuzuOrderEntity() {

	}

	public ChuzuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChuzuOrder{" +
            "id=" + id +
            ", chuzuId=" + chuzuId +
            ", yonghuId=" + yonghuId +
            ", chuzuOrderDay=" + chuzuOrderDay +
            ", shenheTypes=" + shenheTypes +
            ", chuzuOrderMoney=" + chuzuOrderMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
