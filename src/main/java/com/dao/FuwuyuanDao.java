package com.dao;

import com.entity.FuwuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwuyuanVO;
import com.entity.view.FuwuyuanView;


/**
 * 服务员
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface FuwuyuanDao extends BaseMapper<FuwuyuanEntity> {
	
	List<FuwuyuanVO> selectListVO(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
	
	FuwuyuanVO selectVO(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
	
	List<FuwuyuanView> selectListView(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);

	List<FuwuyuanView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
	
	FuwuyuanView selectView(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
	

}
