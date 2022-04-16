package com.dao;

import com.entity.DiandanpeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiandanpeisongVO;
import com.entity.view.DiandanpeisongView;


/**
 * 点单配送
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiandanpeisongDao extends BaseMapper<DiandanpeisongEntity> {
	
	List<DiandanpeisongVO> selectListVO(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
	
	DiandanpeisongVO selectVO(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
	
	List<DiandanpeisongView> selectListView(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);

	List<DiandanpeisongView> selectListView(Pagination page,@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
	
	DiandanpeisongView selectView(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
	

}
