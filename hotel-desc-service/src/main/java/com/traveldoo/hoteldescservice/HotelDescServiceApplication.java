package com.traveldoo.hoteldescservice;

import com.traveldoo.hoteldescservice.models.Rating;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HotelDescServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelDescServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	JedisConnectionFactory getJedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Rating> getRedisTemplate() {
		RedisTemplate<String, Rating> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}
}

