package com.local.test.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRedis {
    private static final Logger logger = Logger.getLogger(TestRedis.class.getName());
    private static final String CLE = "events/city/rome";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static void main(String[] args) throws Exception {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        HostAndPort hostAndPort = new HostAndPort("localhost", 6379);
        Jedis jedis = new Jedis(hostAndPort);

        String cachedResponse = jedis.get(CLE);
        logger.log(Level.INFO, "{0} *-*-*-*-* cacheResponse : {1}", new Object[] {LocalDateTime.now().format(format), cachedResponse});
        jedis.set(CLE, "32,15,223,829", new SetParams().ex(10L));

        for(int i = 0; i < 6; i++) {
            cachedResponse = jedis.get(CLE);
            logger.log(Level.INFO, "{0} *-*-*-*-* cacheResponse : {1}", new Object[] {LocalDateTime.now().format(format), cachedResponse});

            Thread.sleep(3 * 1000);
        }
    }
}
