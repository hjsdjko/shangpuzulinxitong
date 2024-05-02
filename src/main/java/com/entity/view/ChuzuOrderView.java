package com.entity.view;

import com.entity.ChuzuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 商铺出租订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuzu_order")
public class ChuzuOrderView extends ChuzuOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 审核的值
		*/
		private String shenheValue;



		//级联表 chuzu
			/**
			* 商铺名称
			*/
			private String chuzuName;
			/**
			* 户型
			*/
			private Integer huixingTypes;
				/**
				* 户型的值
				*/
				private String huixingValue;
			/**
			* 面积
			*/
			private Double chuzuMianji;
			/**
			* 价格/月
			*/
			private Double chuzuMoney;
			/**
			* 图片
			*/
			private String chuzuPhoto;
			/**
			* 位置
			*/
			private String chuzuWeizhi;
			/**
			* 发布房东
			*/
			private Integer fangdongId;
			/**
			* 商铺状态
			*/
			private Integer chuzuTypes;
				/**
				* 商铺状态的值
				*/
				private String chuzuValue;
			/**
			* 详细信息
			*/
			private String chuzuContent;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 录入时间
			*/
			private Date insertTime;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ChuzuOrderView() {

	}

	public ChuzuOrderView(ChuzuOrderEntity chuzuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chuzuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核的值
			*/
			public String getShenheValue() {
				return shenheValue;
			}
			/**
			* 设置： 审核的值
			*/
			public void setShenheValue(String shenheValue) {
				this.shenheValue = shenheValue;
			}




				//级联表的get和set chuzu
					/**
					* 获取： 商铺名称
					*/
					public String getChuzuName() {
						return chuzuName;
					}
					/**
					* 设置： 商铺名称
					*/
					public void setChuzuName(String chuzuName) {
						this.chuzuName = chuzuName;
					}
					/**
					* 获取： 户型
					*/
					public Integer getHuixingTypes() {
						return huixingTypes;
					}
					/**
					* 设置： 户型
					*/
					public void setHuixingTypes(Integer huixingTypes) {
						this.huixingTypes = huixingTypes;
					}


						/**
						* 获取： 户型的值
						*/
						public String getHuixingValue() {
							return huixingValue;
						}
						/**
						* 设置： 户型的值
						*/
						public void setHuixingValue(String huixingValue) {
							this.huixingValue = huixingValue;
						}
					/**
					* 获取： 面积
					*/
					public Double getChuzuMianji() {
						return chuzuMianji;
					}
					/**
					* 设置： 面积
					*/
					public void setChuzuMianji(Double chuzuMianji) {
						this.chuzuMianji = chuzuMianji;
					}
					/**
					* 获取： 价格/月
					*/
					public Double getChuzuMoney() {
						return chuzuMoney;
					}
					/**
					* 设置： 价格/月
					*/
					public void setChuzuMoney(Double chuzuMoney) {
						this.chuzuMoney = chuzuMoney;
					}
					/**
					* 获取： 图片
					*/
					public String getChuzuPhoto() {
						return chuzuPhoto;
					}
					/**
					* 设置： 图片
					*/
					public void setChuzuPhoto(String chuzuPhoto) {
						this.chuzuPhoto = chuzuPhoto;
					}
					/**
					* 获取： 位置
					*/
					public String getChuzuWeizhi() {
						return chuzuWeizhi;
					}
					/**
					* 设置： 位置
					*/
					public void setChuzuWeizhi(String chuzuWeizhi) {
						this.chuzuWeizhi = chuzuWeizhi;
					}
					/**
					* 获取： 发布房东
					*/
					public Integer getFangdongId() {
						return fangdongId;
					}
					/**
					* 设置： 发布房东
					*/
					public void setFangdongId(Integer fangdongId) {
						this.fangdongId = fangdongId;
					}
					/**
					* 获取： 商铺状态
					*/
					public Integer getChuzuTypes() {
						return chuzuTypes;
					}
					/**
					* 设置： 商铺状态
					*/
					public void setChuzuTypes(Integer chuzuTypes) {
						this.chuzuTypes = chuzuTypes;
					}


						/**
						* 获取： 商铺状态的值
						*/
						public String getChuzuValue() {
							return chuzuValue;
						}
						/**
						* 设置： 商铺状态的值
						*/
						public void setChuzuValue(String chuzuValue) {
							this.chuzuValue = chuzuValue;
						}
					/**
					* 获取： 详细信息
					*/
					public String getChuzuContent() {
						return chuzuContent;
					}
					/**
					* 设置： 详细信息
					*/
					public void setChuzuContent(String chuzuContent) {
						this.chuzuContent = chuzuContent;
					}
					/**
					* 获取： 录入时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 录入时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}



















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}
