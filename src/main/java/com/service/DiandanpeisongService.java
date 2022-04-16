package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiandanpeisongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiandanpeisongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiandanpeisongView;


/**
 * 点单配送
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface DiandanpeisongService extends IService<DiandanpeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiandanpeisongVO> selectListVO(Wrapper<DiandanpeisongEntity> wrapper);
   	
   	DiandanpeisongVO selectVO(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
   	
   	List<DiandanpeisongView> selectListView(Wrapper<DiandanpeisongEntity> wrapper);
   	
   	DiandanpeisongView selectView(@Param("ew") Wrapper<DiandanpeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiandanpeisongEntity> wrapper);
   	

}

