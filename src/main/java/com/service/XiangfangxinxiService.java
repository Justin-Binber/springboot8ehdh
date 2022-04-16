package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangfangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangfangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangfangxinxiView;


/**
 * 厢房信息
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangxinxiService extends IService<XiangfangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangfangxinxiVO> selectListVO(Wrapper<XiangfangxinxiEntity> wrapper);
   	
   	XiangfangxinxiVO selectVO(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
   	
   	List<XiangfangxinxiView> selectListView(Wrapper<XiangfangxinxiEntity> wrapper);
   	
   	XiangfangxinxiView selectView(@Param("ew") Wrapper<XiangfangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangfangxinxiEntity> wrapper);
   	

}

