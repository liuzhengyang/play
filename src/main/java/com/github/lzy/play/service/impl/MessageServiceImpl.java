package com.github.lzy.play.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.lzy.play.domain.Message;
import com.github.lzy.play.service.IIdService;
import com.github.lzy.play.service.IMessageService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
@Service
public class MessageServiceImpl implements IMessageService {
	@Resource
	private IIdService iIdService;

	@Override
	public void sendMessage(Message message) {
		long uniqueId = iIdService.getUniqueId();
		message.setStatus(0);
		// check message
		Jedis jedis = new Jedis();
		Long message1 = jedis.zadd("message", uniqueId, JSON.toJSONString(message));
	}

	@Override
	public List<Message> getMessageList(Long userId) {
		return null;
	}
}
