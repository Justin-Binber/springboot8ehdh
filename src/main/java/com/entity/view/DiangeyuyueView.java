package com.entity.view;

import com.entity.DiangeyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 点歌预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("diangeyuyue")
public class DiangeyuyueView  extends DiangeyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiangeyuyueView(){
	}
 
 	public DiangeyuyueView(DiangeyuyueEntity diangeyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, diangeyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
