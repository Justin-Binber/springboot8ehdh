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

import com.entity.DiandanpeisongEntity;
import com.entity.view.DiandanpeisongView;

import com.service.DiandanpeisongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 点单配送
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@RestController
@RequestMapping("/diandanpeisong")
public class DiandanpeisongController {
    @Autowired
    private DiandanpeisongService diandanpeisongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiandanpeisongEntity diandanpeisong,
                @RequestParam(required = false) Double danjiastart,
                @RequestParam(required = false) Double danjiaend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			diandanpeisong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fuwuyuan")) {
			diandanpeisong.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DiandanpeisongEntity> ew = new EntityWrapper<DiandanpeisongEntity>();
                if(danjiastart!=null) ew.ge("danjia", danjiastart);
                if(danjiaend!=null) ew.le("danjia", danjiaend);
		PageUtils page = diandanpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diandanpeisong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiandanpeisongEntity diandanpeisong, 
                @RequestParam(required = false) Double danjiastart,
                @RequestParam(required = false) Double danjiaend,
		HttpServletRequest request){
        EntityWrapper<DiandanpeisongEntity> ew = new EntityWrapper<DiandanpeisongEntity>();
                if(danjiastart!=null) ew.ge("danjia", danjiastart);
                if(danjiaend!=null) ew.le("danjia", danjiaend);
		PageUtils page = diandanpeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diandanpeisong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiandanpeisongEntity diandanpeisong){
       	EntityWrapper<DiandanpeisongEntity> ew = new EntityWrapper<DiandanpeisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diandanpeisong, "diandanpeisong")); 
        return R.ok().put("data", diandanpeisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiandanpeisongEntity diandanpeisong){
        EntityWrapper< DiandanpeisongEntity> ew = new EntityWrapper< DiandanpeisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diandanpeisong, "diandanpeisong")); 
		DiandanpeisongView diandanpeisongView =  diandanpeisongService.selectView(ew);
		return R.ok("查询点单配送成功").put("data", diandanpeisongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiandanpeisongEntity diandanpeisong = diandanpeisongService.selectById(id);
        return R.ok().put("data", diandanpeisong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiandanpeisongEntity diandanpeisong = diandanpeisongService.selectById(id);
        return R.ok().put("data", diandanpeisong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiandanpeisongEntity diandanpeisong, HttpServletRequest request){
    	diandanpeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diandanpeisong);
        diandanpeisongService.insert(diandanpeisong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiandanpeisongEntity diandanpeisong, HttpServletRequest request){
    	diandanpeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diandanpeisong);
        diandanpeisongService.insert(diandanpeisong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiandanpeisongEntity diandanpeisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diandanpeisong);
        diandanpeisongService.updateById(diandanpeisong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diandanpeisongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiandanpeisongEntity> wrapper = new EntityWrapper<DiandanpeisongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fuwuyuan")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = diandanpeisongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
