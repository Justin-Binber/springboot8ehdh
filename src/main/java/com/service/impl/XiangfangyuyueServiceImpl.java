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


import com.dao.XiangfangyuyueDao;
import com.entity.XiangfangyuyueEntity;
import com.service.XiangfangyuyueService;
import com.entity.vo.XiangfangyuyueVO;
import com.entity.view.XiangfangyuyueView;

@Service("xiangfangyuyueService")
public class XiangfangyuyueServiceImpl extends ServiceImpl<XiangfangyuyueDao, XiangfangyuyueEntity> implements XiangfangyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangfangyuyueEntity> page = this.selectPage(
                new Query<XiangfangyuyueEntity>(params).getPage(),
                new EntityWrapper<XiangfangyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangfangyuyueEntity> wrapper) {
		  Page<XiangfangyuyueView> page =new Query<XiangfangyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangfangyuyueVO> selectListVO(Wrapper<XiangfangyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangfangyuyueVO selectVO(Wrapper<XiangfangyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangfangyuyueView> selectListView(Wrapper<XiangfangyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangfangyuyueView selectView(Wrapper<XiangfangyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
