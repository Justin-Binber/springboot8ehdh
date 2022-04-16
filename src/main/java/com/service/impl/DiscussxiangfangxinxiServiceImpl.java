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


import com.dao.DiscussxiangfangxinxiDao;
import com.entity.DiscussxiangfangxinxiEntity;
import com.service.DiscussxiangfangxinxiService;
import com.entity.vo.DiscussxiangfangxinxiVO;
import com.entity.view.DiscussxiangfangxinxiView;

@Service("discussxiangfangxinxiService")
public class DiscussxiangfangxinxiServiceImpl extends ServiceImpl<DiscussxiangfangxinxiDao, DiscussxiangfangxinxiEntity> implements DiscussxiangfangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiangfangxinxiEntity> page = this.selectPage(
                new Query<DiscussxiangfangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiangfangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiangfangxinxiEntity> wrapper) {
		  Page<DiscussxiangfangxinxiView> page =new Query<DiscussxiangfangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxiangfangxinxiVO> selectListVO(Wrapper<DiscussxiangfangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxiangfangxinxiVO selectVO(Wrapper<DiscussxiangfangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxiangfangxinxiView> selectListView(Wrapper<DiscussxiangfangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiangfangxinxiView selectView(Wrapper<DiscussxiangfangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
