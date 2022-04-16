package com.dao;

import com.entity.XiangfangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangfangxinxiVO;
import com.entity.view.XiangfangxinxiView;


/**
 * 厢房信息
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangxinxiDao extends BaseMapper<XiangfangxinxiEntity> {
	
	List<XiangfangxinxiVO> selectListVO(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
	
	XiangfangxinxiVO selectVO(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
	
	List<XiangfangxinxiView> selectListView(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);

	List<XiangfangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
	
	XiangfangxinxiView selectView(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
	

}
