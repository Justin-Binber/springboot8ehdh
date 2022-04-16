package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangpindiandanDao;
import com.entity.ShangpindiandanEntity;
import com.service.ShangpindiandanService;
import com.entity.vo.ShangpindiandanVO;
import com.entity.view.ShangpindiandanView;

@Service("shangpindiandanService")
public class ShangpindiandanServiceImpl extends ServiceImpl<ShangpindiandanDao, ShangpindiandanEntity> implements ShangpindiandanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpindiandanEntity> page = this.selectPage(
                new Query<ShangpindiandanEntity>(params).getPage(),
                new EntityWrapper<ShangpindiandanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpindiandanEntity> wrapper) {
		  Page<ShangpindiandanView> page =new Query<ShangpindiandanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpindiandanVO> selectListVO(Wrapper<ShangpindiandanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpindiandanVO selectVO(Wrapper<ShangpindiandanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpindiandanView> selectListView(Wrapper<ShangpindiandanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpindiandanView selectView(Wrapper<ShangpindiandanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
