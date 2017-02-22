package com.github.lzy.play.controller;

import com.github.lzy.play.domain.User;
import com.github.lzy.play.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	@Resource
	private UserMapper userMapper;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/user")
	public User user(long userId) {
		User userById = userMapper.getUserById(userId);
		return userById;
	}
}
