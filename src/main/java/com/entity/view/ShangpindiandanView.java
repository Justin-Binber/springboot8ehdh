package com.entity.view;

import com.entity.ShangpindiandanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品点单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("shangpindiandan")
public class ShangpindiandanView  extends ShangpindiandanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangpindiandanView(){
	}
 
 	public ShangpindiandanView(ShangpindiandanEntity shangpindiandanEntity){
 	try {
			BeanUtils.copyProperties(this, shangpindiandanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
