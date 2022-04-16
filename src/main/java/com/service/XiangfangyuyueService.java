package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangfangyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangfangyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangfangyuyueView;


/**
 * 厢房预约
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface XiangfangyuyueService extends IService<XiangfangyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangfangyuyueVO> selectListVO(Wrapper<XiangfangyuyueEntity> wrapper);
   	
   	XiangfangyuyueVO selectVO(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
   	
   	List<XiangfangyuyueView> selectListView(Wrapper<XiangfangyuyueEntity> wrapper);
   	
   	XiangfangyuyueView selectView(@Param("ew") Wrapper<XiangfangyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangfangyuyueEntity> wrapper);
   	

}

