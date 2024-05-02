package com.entity.vo;

import com.entity.HetongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 合同信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hetong")
public class HetongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 合同名称
     */

    @TableField(value = "hetong_name")
    private String hetongName;


    /**
     * 签订用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 发布房东
     */

    @TableField(value = "fangdong_id")
    private Integer fangdongId;


    /**
     * 合同
     */

    @TableField(value = "hetong_file")
    private String hetongFile;


    /**
     * 合同简介
     */

    @TableField(value = "hetong_content")
    private String hetongContent;


    /**
     * 签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：合同名称
	 */
    public String getHetongName() {
        return hetongName;
    }


    /**
	 * 获取：合同名称
	 */

    public void setHetongName(String hetongName) {
        this.hetongName = hetongName;
    }
    /**
	 * 设置：签订用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：签订用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 设置：合同
	 */
    public String getHetongFile() {
        return hetongFile;
    }


    /**
	 * 获取：合同
	 */

    public void setHetongFile(String hetongFile) {
        this.hetongFile = hetongFile;
    }
    /**
	 * 设置：合同简介
	 */
    public String getHetongContent() {
        return hetongContent;
    }


    /**
	 * 获取：合同简介
	 */

    public void setHetongContent(String hetongContent) {
        this.hetongContent = hetongContent;
    }
    /**
	 * 设置：签订时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：签订时间
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

}
