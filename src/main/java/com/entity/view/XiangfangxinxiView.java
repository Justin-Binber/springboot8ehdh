package com.entity.view;

import com.entity.XiangfangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 厢房信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("xiangfangxinxi")
public class XiangfangxinxiView  extends XiangfangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiangfangxinxiView(){
	}
 
 	public XiangfangxinxiView(XiangfangxinxiEntity xiangfangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, xiangfangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
