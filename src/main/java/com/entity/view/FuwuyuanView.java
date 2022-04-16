package com.entity.view;

import com.entity.FuwuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服务员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("fuwuyuan")
public class FuwuyuanView  extends FuwuyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwuyuanView(){
	}
 
 	public FuwuyuanView(FuwuyuanEntity fuwuyuanEntity){
 	try {
			BeanUtils.copyProperties(this, fuwuyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
