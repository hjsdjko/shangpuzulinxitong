package com.entity.model;

import com.entity.HetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 合同信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HetongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 合同名称
     */
    private String hetongName;


    /**
     * 签订用户
     */
    private Integer yonghuId;


    /**
     * 发布房东
     */
    private Integer fangdongId;


    /**
     * 合同
     */
    private String hetongFile;


    /**
     * 合同简介
     */
    private String hetongContent;


    /**
     * 签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：合同名称
	 */
    public String getHetongName() {
        return hetongName;
    }


    /**
	 * 设置：合同名称
	 */
    public void setHetongName(String hetongName) {
        this.hetongName = hetongName;
    }
    /**
	 * 获取：签订用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：签订用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：发布房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }


    /**
	 * 设置：发布房东
	 */
    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 获取：合同
	 */
    public String getHetongFile() {
        return hetongFile;
    }


    /**
	 * 设置：合同
	 */
    public void setHetongFile(String hetongFile) {
        this.hetongFile = hetongFile;
    }
    /**
	 * 获取：合同简介
	 */
    public String getHetongContent() {
        return hetongContent;
    }


    /**
	 * 设置：合同简介
	 */
    public void setHetongContent(String hetongContent) {
        this.hetongContent = hetongContent;
    }
    /**
	 * 获取：签订时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：签订时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
