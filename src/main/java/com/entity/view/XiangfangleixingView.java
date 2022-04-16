package com.entity.view;

import com.entity.XiangfangleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 厢房类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("xiangfangleixing")
public class XiangfangleixingView  extends XiangfangleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiangfangleixingView(){
	}
 
 	public XiangfangleixingView(XiangfangleixingEntity xiangfangleixingEntity){
 	try {
			BeanUtils.copyProperties(this, xiangfangleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
