package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwuyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwuyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuyuanView;


/**
 * 服务员
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface FuwuyuanService extends IService<FuwuyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuyuanVO> selectListVO(Wrapper<FuwuyuanEntity> wrapper);
   	
   	FuwuyuanVO selectVO(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
   	
   	List<FuwuyuanView> selectListView(Wrapper<FuwuyuanEntity> wrapper);
   	
   	FuwuyuanView selectView(@Param("ew") Wrapper<FuwuyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuyuanEntity> wrapper);
   	

}

