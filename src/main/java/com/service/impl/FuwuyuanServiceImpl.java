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


import com.dao.FuwuyuanDao;
import com.entity.FuwuyuanEntity;
import com.service.FuwuyuanService;
import com.entity.vo.FuwuyuanVO;
import com.entity.view.FuwuyuanView;

@Service("fuwuyuanService")
public class FuwuyuanServiceImpl extends ServiceImpl<FuwuyuanDao, FuwuyuanEntity> implements FuwuyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuyuanEntity> page = this.selectPage(
                new Query<FuwuyuanEntity>(params).getPage(),
                new EntityWrapper<FuwuyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuyuanEntity> wrapper) {
		  Page<FuwuyuanView> page =new Query<FuwuyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FuwuyuanVO> selectListVO(Wrapper<FuwuyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwuyuanVO selectVO(Wrapper<FuwuyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwuyuanView> selectListView(Wrapper<FuwuyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuyuanView selectView(Wrapper<FuwuyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
