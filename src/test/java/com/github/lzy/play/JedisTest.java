package com.github.lzy.play;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-24
 */
public class JedisTest {
	@Test
	public void testJedisStart() {
		Jedis jedis = new Jedis();
		jedis.set("test", "hello world");
		System.out.println(jedis.get("test"));
	}
}
