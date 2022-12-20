package com.vtxlab.crypto.admin.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.vtxlab.crypto.admin.entity.Channel;

@Configuration
public class RedisTemplateConfig {

  @Bean(name = "redisTemplate")
  public RedisTemplate<String, Channel> redisTemplate(
      RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Channel> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(connectionFactory);
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(stringRedisSerializer);
    // Add some specific configuration here. Key serializers, etc.
    return redisTemplate;
  }

}
