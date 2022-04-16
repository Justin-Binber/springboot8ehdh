package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WanchengdingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WanchengdingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WanchengdingdanView;


/**
 * 完成订单
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface WanchengdingdanService extends IService<WanchengdingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WanchengdingdanVO> selectListVO(Wrapper<WanchengdingdanEntity> wrapper);
   	
   	WanchengdingdanVO selectVO(@Param("ew") Wrapper<WanchengdingdanEntity> wrapper);
   	
   	List<WanchengdingdanView> selectListView(Wrapper<WanchengdingdanEntity> wrapper);
   	
   	WanchengdingdanView selectView(@Param("ew") Wrapper<WanchengdingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WanchengdingdanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WanchengdingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WanchengdingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WanchengdingdanEntity> wrapper);
}

