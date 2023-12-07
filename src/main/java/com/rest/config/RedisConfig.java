package com.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.rest.binding.Country;

@Component
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConn() {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		// Redis server properties
		jedis.setHostName("127.0.0.1");
		jedis.setPort(6379);
		jedis.afterPropertiesSet();
		return jedis;
	}

	@Bean
	public RedisTemplate<String, Country> redisTemplate() {
		RedisTemplate<String, Country> rt = new RedisTemplate<String, Country>();
		rt.setConnectionFactory(jedisConn());
		return rt;
	}

}
