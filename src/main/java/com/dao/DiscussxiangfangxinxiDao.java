package com.dao;

import com.entity.DiscussxiangfangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxiangfangxinxiVO;
import com.entity.view.DiscussxiangfangxinxiView;


/**
 * 厢房信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiscussxiangfangxinxiDao extends BaseMapper<DiscussxiangfangxinxiEntity> {
	
	List<DiscussxiangfangxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
	
	DiscussxiangfangxinxiVO selectVO(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
	
	List<DiscussxiangfangxinxiView> selectListView(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);

	List<DiscussxiangfangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
	
	DiscussxiangfangxinxiView selectView(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
	

}
