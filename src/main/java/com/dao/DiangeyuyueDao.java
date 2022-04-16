package com.dao;

import com.entity.DiangeyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiangeyuyueVO;
import com.entity.view.DiangeyuyueView;


/**
 * 点歌预约
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiangeyuyueDao extends BaseMapper<DiangeyuyueEntity> {
	
	List<DiangeyuyueVO> selectListVO(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
	
	DiangeyuyueVO selectVO(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
	
	List<DiangeyuyueView> selectListView(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);

	List<DiangeyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
	
	DiangeyuyueView selectView(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
	

}
