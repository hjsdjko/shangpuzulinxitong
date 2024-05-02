package com.entity.vo;

import com.entity.ChuzuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商铺出租
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuzu")
public class ChuzuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商铺名称
     */

    @TableField(value = "chuzu_name")
    private String chuzuName;


    /**
     * 户型
     */

    @TableField(value = "huixing_types")
    private Integer huixingTypes;


    /**
     * 面积
     */

    @TableField(value = "chuzu_mianji")
    private Double chuzuMianji;


    /**
     * 价格/月
     */

    @TableField(value = "chuzu_money")
    private Double chuzuMoney;


    /**
     * 图片
     */

    @TableField(value = "chuzu_photo")
    private String chuzuPhoto;


    /**
     * 位置
     */

    @TableField(value = "chuzu_weizhi")
    private String chuzuWeizhi;


    /**
     * 发布房东
     */

    @TableField(value = "fangdong_id")
    private Integer fangdongId;


    /**
     * 商铺状态
     */

    @TableField(value = "chuzu_types")
    private Integer chuzuTypes;


    /**
     * 详细信息
     */

    @TableField(value = "chuzu_content")
    private String chuzuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：商铺名称
	 */
    public String getChuzuName() {
        return chuzuName;
    }


    /**
	 * 获取：商铺名称
	 */

    public void setChuzuName(String chuzuName) {
        this.chuzuName = chuzuName;
    }
    /**
	 * 设置：户型
	 */
    public Integer getHuixingTypes() {
        return huixingTypes;
    }


    /**
	 * 获取：户型
	 */

    public void setHuixingTypes(Integer huixingTypes) {
        this.huixingTypes = huixingTypes;
    }
    /**
	 * 设置：面积
	 */
    public Double getChuzuMianji() {
        return chuzuMianji;
    }


    /**
	 * 获取：面积
	 */

    public void setChuzuMianji(Double chuzuMianji) {
        this.chuzuMianji = chuzuMianji;
    }
    /**
	 * 设置：价格/月
	 */
    public Double getChuzuMoney() {
        return chuzuMoney;
    }


    /**
	 * 获取：价格/月
	 */

    public void setChuzuMoney(Double chuzuMoney) {
        this.chuzuMoney = chuzuMoney;
    }
    /**
	 * 设置：图片
	 */
    public String getChuzuPhoto() {
        return chuzuPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setChuzuPhoto(String chuzuPhoto) {
        this.chuzuPhoto = chuzuPhoto;
    }
    /**
	 * 设置：位置
	 */
    public String getChuzuWeizhi() {
        return chuzuWeizhi;
    }


    /**
	 * 获取：位置
	 */

    public void setChuzuWeizhi(String chuzuWeizhi) {
        this.chuzuWeizhi = chuzuWeizhi;
    }
    /**
	 * 设置：发布房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }


    /**
	 * 获取：发布房东
	 */

    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 设置：商铺状态
	 */
    public Integer getChuzuTypes() {
        return chuzuTypes;
    }


    /**
	 * 获取：商铺状态
	 */

    public void setChuzuTypes(Integer chuzuTypes) {
        this.chuzuTypes = chuzuTypes;
    }
    /**
	 * 设置：详细信息
	 */
    public String getChuzuContent() {
        return chuzuContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setChuzuContent(String chuzuContent) {
        this.chuzuContent = chuzuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
