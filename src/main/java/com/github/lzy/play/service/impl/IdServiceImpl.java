package com.github.lzy.play.service.impl;

import com.github.lzy.play.service.IIdService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
@Service
public class IdServiceImpl implements IIdService {
	private Jedis jedis = new Jedis();
	@Override
	public long getUniqueId() {
		Long uniqueId = jedis.incr("uniqueId");
		return uniqueId;
	}
}
