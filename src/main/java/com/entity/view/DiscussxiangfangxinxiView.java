package com.entity.view;

import com.entity.DiscussxiangfangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 厢房信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@TableName("discussxiangfangxinxi")
public class DiscussxiangfangxinxiView  extends DiscussxiangfangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiangfangxinxiView(){
	}
 
 	public DiscussxiangfangxinxiView(DiscussxiangfangxinxiEntity discussxiangfangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiangfangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
