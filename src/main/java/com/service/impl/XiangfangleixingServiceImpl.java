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


import com.dao.XiangfangleixingDao;
import com.entity.XiangfangleixingEntity;
import com.service.XiangfangleixingService;
import com.entity.vo.XiangfangleixingVO;
import com.entity.view.XiangfangleixingView;

@Service("xiangfangleixingService")
public class XiangfangleixingServiceImpl extends ServiceImpl<XiangfangleixingDao, XiangfangleixingEntity> implements XiangfangleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangfangleixingEntity> page = this.selectPage(
                new Query<XiangfangleixingEntity>(params).getPage(),
                new EntityWrapper<XiangfangleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangfangleixingEntity> wrapper) {
		  Page<XiangfangleixingView> page =new Query<XiangfangleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangfangleixingVO> selectListVO(Wrapper<XiangfangleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangfangleixingVO selectVO(Wrapper<XiangfangleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangfangleixingView> selectListView(Wrapper<XiangfangleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangfangleixingView selectView(Wrapper<XiangfangleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
