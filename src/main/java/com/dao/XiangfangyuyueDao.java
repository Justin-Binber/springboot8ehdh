package com.dao;

import com.entity.XiangfangyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangfangyuyueVO;
import com.entity.view.XiangfangyuyueView;


/**
 * 厢房预约
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangyuyueDao extends BaseMapper<XiangfangyuyueEntity> {
	
	List<XiangfangyuyueVO> selectListVO(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
	
	XiangfangyuyueVO selectVO(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
	
	List<XiangfangyuyueView> selectListView(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);

	List<XiangfangyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
	
	XiangfangyuyueView selectView(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
	

}
