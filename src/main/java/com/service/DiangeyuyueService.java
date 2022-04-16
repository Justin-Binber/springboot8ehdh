package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiangeyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiangeyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiangeyuyueView;


/**
 * 点歌预约
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiangeyuyueService extends IService<DiangeyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiangeyuyueVO> selectListVO(Wrapper<DiangeyuyueEntity> wrapper);
   	
   	DiangeyuyueVO selectVO(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
   	
   	List<DiangeyuyueView> selectListView(Wrapper<DiangeyuyueEntity> wrapper);
   	
   	DiangeyuyueView selectView(@Param("ew") Wrapper<DiangeyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiangeyuyueEntity> wrapper);
   	

}

