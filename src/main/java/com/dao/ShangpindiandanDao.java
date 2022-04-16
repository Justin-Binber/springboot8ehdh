package com.dao;

import com.entity.ShangpindiandanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpindiandanVO;
import com.entity.view.ShangpindiandanView;


/**
 * 商品点单
 * 
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface ShangpindiandanDao extends BaseMapper<ShangpindiandanEntity> {
	
	List<ShangpindiandanVO> selectListVO(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
	
	ShangpindiandanVO selectVO(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
	
	List<ShangpindiandanView> selectListView(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);

	List<ShangpindiandanView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
	
	ShangpindiandanView selectView(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
	

}
