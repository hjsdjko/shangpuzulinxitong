package com.entity.view;

import com.entity.HetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 合同信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hetong")
public class HetongView extends HetongEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 fangdong
			/**
			* 房东姓名
			*/
			private String fangdongName;
			/**
			* 身份证号
			*/
			private String fangdongIdNumber;
			/**
			* 手机号
			*/
			private String fangdongPhone;
			/**
			* 照片
			*/
			private String fangdongPhoto;

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

	public HetongView() {

	}

	public HetongView(HetongEntity hetongEntity) {
		try {
			BeanUtils.copyProperties(this, hetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




















				//级联表的get和set fangdong
					/**
					* 获取： 房东姓名
					*/
					public String getFangdongName() {
						return fangdongName;
					}
					/**
					* 设置： 房东姓名
					*/
					public void setFangdongName(String fangdongName) {
						this.fangdongName = fangdongName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getFangdongIdNumber() {
						return fangdongIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setFangdongIdNumber(String fangdongIdNumber) {
						this.fangdongIdNumber = fangdongIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getFangdongPhone() {
						return fangdongPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setFangdongPhone(String fangdongPhone) {
						this.fangdongPhone = fangdongPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getFangdongPhoto() {
						return fangdongPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setFangdongPhoto(String fangdongPhoto) {
						this.fangdongPhoto = fangdongPhoto;
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
