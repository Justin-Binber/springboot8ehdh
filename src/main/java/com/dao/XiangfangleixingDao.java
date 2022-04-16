package com.dao;

import com.entity.XiangfangleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangfangleixingVO;
import com.entity.view.XiangfangleixingView;


/**
 * 厢房类型
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangleixingDao extends BaseMapper<XiangfangleixingEntity> {
	
	List<XiangfangleixingVO> selectListVO(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
	
	XiangfangleixingVO selectVO(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
	
	List<XiangfangleixingView> selectListView(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);

	List<XiangfangleixingView> selectListView(Pagination page,@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
	
	XiangfangleixingView selectView(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
	

}
