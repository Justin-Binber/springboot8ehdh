package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxiangfangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxiangfangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxiangfangxinxiView;


/**
 * 厢房信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiscussxiangfangxinxiService extends IService<DiscussxiangfangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiangfangxinxiVO> selectListVO(Wrapper<DiscussxiangfangxinxiEntity> wrapper);
   	
   	DiscussxiangfangxinxiVO selectVO(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
   	
   	List<DiscussxiangfangxinxiView> selectListView(Wrapper<DiscussxiangfangxinxiEntity> wrapper);
   	
   	DiscussxiangfangxinxiView selectView(@Param("ew") Wrapper<DiscussxiangfangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiangfangxinxiEntity> wrapper);
   	

}

