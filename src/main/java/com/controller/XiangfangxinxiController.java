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

import com.entity.XiangfangxinxiEntity;
import com.entity.view.XiangfangxinxiView;

import com.service.XiangfangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 厢房信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-02 13:36:53
 */
@RestController
@RequestMapping("/xiangfangxinxi")
public class XiangfangxinxiController {
    @Autowired
    private XiangfangxinxiService xiangfangxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangfangxinxiEntity xiangfangxinxi,
		HttpServletRequest request){
        EntityWrapper<XiangfangxinxiEntity> ew = new EntityWrapper<XiangfangxinxiEntity>();
		PageUtils page = xiangfangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangfangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangfangxinxiEntity xiangfangxinxi, 
		HttpServletRequest request){
        EntityWrapper<XiangfangxinxiEntity> ew = new EntityWrapper<XiangfangxinxiEntity>();
		PageUtils page = xiangfangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangfangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangfangxinxiEntity xiangfangxinxi){
       	EntityWrapper<XiangfangxinxiEntity> ew = new EntityWrapper<XiangfangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangfangxinxi, "xiangfangxinxi")); 
        return R.ok().put("data", xiangfangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangfangxinxiEntity xiangfangxinxi){
        EntityWrapper< XiangfangxinxiEntity> ew = new EntityWrapper< XiangfangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangfangxinxi, "xiangfangxinxi")); 
		XiangfangxinxiView xiangfangxinxiView =  xiangfangxinxiService.selectView(ew);
		return R.ok("查询厢房信息成功").put("data", xiangfangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangfangxinxiEntity xiangfangxinxi = xiangfangxinxiService.selectById(id);
		xiangfangxinxi.setClicktime(new Date());
		xiangfangxinxiService.updateById(xiangfangxinxi);
        return R.ok().put("data", xiangfangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangfangxinxiEntity xiangfangxinxi = xiangfangxinxiService.selectById(id);
		xiangfangxinxi.setClicktime(new Date());
		xiangfangxinxiService.updateById(xiangfangxinxi);
        return R.ok().put("data", xiangfangxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiangfangxinxiEntity xiangfangxinxi = xiangfangxinxiService.selectById(id);
        if(type.equals("1")) {
        	xiangfangxinxi.setThumbsupnum(xiangfangxinxi.getThumbsupnum()+1);
        } else {
        	xiangfangxinxi.setCrazilynum(xiangfangxinxi.getCrazilynum()+1);
        }
        xiangfangxinxiService.updateById(xiangfangxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangfangxinxiEntity xiangfangxinxi, HttpServletRequest request){
    	xiangfangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangfangxinxi);
        xiangfangxinxiService.insert(xiangfangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangfangxinxiEntity xiangfangxinxi, HttpServletRequest request){
    	xiangfangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangfangxinxi);
        xiangfangxinxiService.insert(xiangfangxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XiangfangxinxiEntity xiangfangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangfangxinxi);
        xiangfangxinxiService.updateById(xiangfangxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangfangxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XiangfangxinxiEntity> wrapper = new EntityWrapper<XiangfangxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xiangfangxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiangfangxinxiEntity xiangfangxinxi, HttpServletRequest request,String pre){
        EntityWrapper<XiangfangxinxiEntity> ew = new EntityWrapper<XiangfangxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = xiangfangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangfangxinxi), params), params));
        return R.ok().put("data", page);
    }







}
