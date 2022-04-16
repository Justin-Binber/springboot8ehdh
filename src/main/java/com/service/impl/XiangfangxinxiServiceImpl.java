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


import com.dao.XiangfangxinxiDao;
import com.entity.XiangfangxinxiEntity;
import com.service.XiangfangxinxiService;
import com.entity.vo.XiangfangxinxiVO;
import com.entity.view.XiangfangxinxiView;

@Service("xiangfangxinxiService")
public class XiangfangxinxiServiceImpl extends ServiceImpl<XiangfangxinxiDao, XiangfangxinxiEntity> implements XiangfangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangfangxinxiEntity> page = this.selectPage(
                new Query<XiangfangxinxiEntity>(params).getPage(),
                new EntityWrapper<XiangfangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangfangxinxiEntity> wrapper) {
		  Page<XiangfangxinxiView> page =new Query<XiangfangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangfangxinxiVO> selectListVO(Wrapper<XiangfangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangfangxinxiVO selectVO(Wrapper<XiangfangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangfangxinxiView> selectListView(Wrapper<XiangfangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangfangxinxiView selectView(Wrapper<XiangfangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
