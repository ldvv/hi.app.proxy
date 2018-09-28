package com.sys.gateway.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConfigurationProperties(prefix="redis")
public class RedisConfig {

    private String host;

    private String port;

    private String password;

    // 最大空闲数
    private Integer maxIdle = 200;

    // 最小空闲数
    private Integer minIdle = 100;

    // 连接池的最大数据库连接数
    private Integer maxTotal = 1000;

    // 最大建立连接等待时间
    private Integer maxWaitMillis = 10*1000;

    // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
    private Integer minEvictableIdleTimeMillis = 10*60*1000;

    // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
    private Integer numTestsPerEvictionRun = 3;

    // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
    private long timeBetweenEvictionRunsMillis = -1;

    // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
    private boolean testOnBorrow = true;

    // 在空闲时检查有效性, 默认false
    private boolean testWhileIdle = false;



    /**
     * JedisPoolConfig 连接池
     * @return
     */
    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }

    /**
     * 配置连接工厂
     * @Title: JedisConnectionFactory
     * @param @param jedisPoolConfig
     * @param @return
     * @return JedisConnectionFactory
     * @autor lpl
     * @date 2018年2月24日
     * @throws
     */
    @Bean
    public JedisConnectionFactory JedisConnectionFactory(){
        //通过用户名密码初始化Redis基本信息用于连接Redis
        RedisStandaloneConfiguration standaloneCfg = new RedisStandaloneConfiguration(host, Integer.parseInt(port));
        standaloneCfg.setPassword(RedisPassword.of(password));

        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();

        //注入连接池配置
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisClientBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        JedisClientConfiguration poolConfig = jedisClientBuilder.poolConfig(jedisPoolConfig).build();

        //初始化连接池
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(standaloneCfg, poolConfig);

        return jedisConnectionFactory;
    }

    /**
     * 实例化 RedisTemplate 对象
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis 的序列化方式,并开启事务
     *
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }

    //读取配置文件设置值
    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
