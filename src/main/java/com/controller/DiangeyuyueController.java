package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiangeyuyueEntity;
import com.entity.view.DiangeyuyueView;

import com.service.DiangeyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 点歌预约
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@RestController
@RequestMapping("/diangeyuyue")
public class DiangeyuyueController {
    @Autowired
    private DiangeyuyueService diangeyuyueService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiangeyuyueEntity diangeyuyue,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		diangeyuyue.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			diangeyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DiangeyuyueEntity> ew = new EntityWrapper<DiangeyuyueEntity>();
		PageUtils page = diangeyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diangeyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiangeyuyueEntity diangeyuyue, 
		HttpServletRequest request){
        EntityWrapper<DiangeyuyueEntity> ew = new EntityWrapper<DiangeyuyueEntity>();
		PageUtils page = diangeyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diangeyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiangeyuyueEntity diangeyuyue){
       	EntityWrapper<DiangeyuyueEntity> ew = new EntityWrapper<DiangeyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diangeyuyue, "diangeyuyue")); 
        return R.ok().put("data", diangeyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiangeyuyueEntity diangeyuyue){
        EntityWrapper< DiangeyuyueEntity> ew = new EntityWrapper< DiangeyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diangeyuyue, "diangeyuyue")); 
		DiangeyuyueView diangeyuyueView =  diangeyuyueService.selectView(ew);
		return R.ok("查询点歌预约成功").put("data", diangeyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiangeyuyueEntity diangeyuyue = diangeyuyueService.selectById(id);
        return R.ok().put("data", diangeyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiangeyuyueEntity diangeyuyue = diangeyuyueService.selectById(id);
        return R.ok().put("data", diangeyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiangeyuyueEntity diangeyuyue, HttpServletRequest request){
    	diangeyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diangeyuyue);
    	diangeyuyue.setUserid((Long)request.getSession().getAttribute("userId"));
        diangeyuyueService.insert(diangeyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiangeyuyueEntity diangeyuyue, HttpServletRequest request){
    	diangeyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diangeyuyue);
        diangeyuyueService.insert(diangeyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiangeyuyueEntity diangeyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diangeyuyue);
        diangeyuyueService.updateById(diangeyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diangeyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiangeyuyueEntity> wrapper = new EntityWrapper<DiangeyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = diangeyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
