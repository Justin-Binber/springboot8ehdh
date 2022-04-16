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


import com.dao.DiangeyuyueDao;
import com.entity.DiangeyuyueEntity;
import com.service.DiangeyuyueService;
import com.entity.vo.DiangeyuyueVO;
import com.entity.view.DiangeyuyueView;

@Service("diangeyuyueService")
public class DiangeyuyueServiceImpl extends ServiceImpl<DiangeyuyueDao, DiangeyuyueEntity> implements DiangeyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiangeyuyueEntity> page = this.selectPage(
                new Query<DiangeyuyueEntity>(params).getPage(),
                new EntityWrapper<DiangeyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiangeyuyueEntity> wrapper) {
		  Page<DiangeyuyueView> page =new Query<DiangeyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiangeyuyueVO> selectListVO(Wrapper<DiangeyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiangeyuyueVO selectVO(Wrapper<DiangeyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiangeyuyueView> selectListView(Wrapper<DiangeyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiangeyuyueView selectView(Wrapper<DiangeyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
