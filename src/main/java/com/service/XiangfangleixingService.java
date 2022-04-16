package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangfangleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangfangleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangfangleixingView;


/**
 * 厢房类型
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangleixingService extends IService<XiangfangleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangfangleixingVO> selectListVO(Wrapper<XiangfangleixingEntity> wrapper);
   	
   	XiangfangleixingVO selectVO(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
   	
   	List<XiangfangleixingView> selectListView(Wrapper<XiangfangleixingEntity> wrapper);
   	
   	XiangfangleixingView selectView(@Param("ew") Wrapper<XiangfangleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangfangleixingEntity> wrapper);
   	

}

