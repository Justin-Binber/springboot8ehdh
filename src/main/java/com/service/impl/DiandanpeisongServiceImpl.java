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


import com.dao.DiandanpeisongDao;
import com.entity.DiandanpeisongEntity;
import com.service.DiandanpeisongService;
import com.entity.vo.DiandanpeisongVO;
import com.entity.view.DiandanpeisongView;

@Service("diandanpeisongService")
public class DiandanpeisongServiceImpl extends ServiceImpl<DiandanpeisongDao, DiandanpeisongEntity> implements DiandanpeisongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiandanpeisongEntity> page = this.selectPage(
                new Query<DiandanpeisongEntity>(params).getPage(),
                new EntityWrapper<DiandanpeisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiandanpeisongEntity> wrapper) {
		  Page<DiandanpeisongView> page =new Query<DiandanpeisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiandanpeisongVO> selectListVO(Wrapper<DiandanpeisongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiandanpeisongVO selectVO(Wrapper<DiandanpeisongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiandanpeisongView> selectListView(Wrapper<DiandanpeisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiandanpeisongView selectView(Wrapper<DiandanpeisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
