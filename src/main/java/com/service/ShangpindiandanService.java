package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpindiandanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpindiandanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpindiandanView;


/**
 * 商品点单
 *
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
public interface ShangpindiandanService extends IService<ShangpindiandanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpindiandanVO> selectListVO(Wrapper<ShangpindiandanEntity> wrapper);
   	
   	ShangpindiandanVO selectVO(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
   	
   	List<ShangpindiandanView> selectListView(Wrapper<ShangpindiandanEntity> wrapper);
   	
   	ShangpindiandanView selectView(@Param("ew") Wrapper<ShangpindiandanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpindiandanEntity> wrapper);
   	

}

