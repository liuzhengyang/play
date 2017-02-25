package com.github.lzy.play.controller;

import com.alibaba.fastjson.JSON;
import com.github.lzy.play.domain.Message;
import com.github.lzy.play.domain.User;
import com.github.lzy.play.mapper.UserMapper;
import com.github.lzy.play.model.MessageModel;
import com.github.lzy.play.param.MessageParam;
import com.github.lzy.play.service.IIdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

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
	@Resource
	private IIdService iIdService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/user")
	public User user(long userId) {
		User userById = userMapper.getUserById(userId);
		return userById;
	}

	@RequestMapping("/message/send")
	public Object sendMessage(MessageParam messageParam) {
		long uniqueId = iIdService.getUniqueId();
		Message message = new Message();
		message.setSenderId(messageParam.getSenderId());
		message.setReceiverId(messageParam.getReceiverId());
		message.setSendTime(new Date(messageParam.getSendTime()));
		message.setId(uniqueId);
		message.setContent(messageParam.getContent());
		message.setStatus(0);
		// check message
		Long toId = message.getReceiverId();
		Jedis jedis = new Jedis();
		Long message1 = jedis.zadd("message", uniqueId, JSON.toJSONString(message));
		return message1;
	}

	@RequestMapping("/message/list")
	public Object getMessageList() {
		Jedis jedis = new Jedis();
		Set<String> message = jedis.zrange("message", 0, Long.MAX_VALUE);
		return message;
	}
}
