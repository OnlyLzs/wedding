package com.application.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_passenger;
import com.application.response.StatusResult;
import com.application.service.IApp_passengerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app旅客表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-24
 */
@Controller
@RequestMapping("/app_passenger")
public class App_passengerController {
	
	private static Logger logger = LoggerFactory.getLogger(App_passengerController.class);
	
	@Autowired
	IApp_passengerService passengerService;
	
	@ResponseBody
	@RequestMapping(value="/user/{user_id}", method=RequestMethod.GET)
	public StatusResult getPassengerList(@PathVariable Integer user_id) {
		logger.info("后台 /user/{user_id}");
		QueryWrapper<App_passenger> query = new QueryWrapper<>();
		query.eq("user_id", user_id);
		List<App_passenger> list = passengerService.list(query);
		return StatusResult.ok(list);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/passenger/{user_id}/{passenger_id}",method=RequestMethod.DELETE)
	public StatusResult delPassenger(@PathVariable Integer user_id, @PathVariable Integer passenger_id) {
		logger.info("后台 /passenger/{user_id}/{passenger_id}");
		boolean result = passengerService.removeById(passenger_id);
		if(result) {
			return StatusResult.ok();
		}
		return StatusResult.error("删除失败");
	}
	
	@ResponseBody
	@RequestMapping(value="/passenger/{user_id}",method=RequestMethod.POST)
	public StatusResult saveOrUpdatePassenger(@PathVariable Integer user_id, Integer passenger_id, String name, String mobile, String identity_card, String passport) {
		
		App_passenger passenger = new App_passenger();
		if(passenger_id!=null) {
			passenger.setId(passenger_id);
		}
		passenger.setName(name);
		passenger.setMobile(mobile);
		passenger.setIdentity_card(identity_card);
		passenger.setPassport(passport);
		passenger.setUser_id(user_id);
		boolean result = passengerService.saveOrUpdate(passenger);
		if(result) {
			return StatusResult.ok();
		}
		return StatusResult.error("添加失败");
	}
	
	@ResponseBody
	@RequestMapping(value="/passenger/{passenger_id}",method=RequestMethod.GET)
	public StatusResult getPassenger(@PathVariable Integer passenger_id) {
		
		App_passenger passenger = passengerService.getById(passenger_id);
		
		return StatusResult.ok(passenger);
	}

}

