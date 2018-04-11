package com.mypack.cache.redis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
 
public class JedisMain {
	private static final Logger log = Logger.getLogger(JedisMain.class);
 
    //address of your redis server
    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;
 
    //the jedis connection pool..
    private static JedisPool pool = null;
 
    public JedisMain() {
        //configure our pool connection
        pool = new JedisPool(redisHost, redisPort);
 
    }
 
    public void addSets() {
        //let us first add some data in our redis server using Redis SET.
        String key = "my-key";
        String member1 = "Imran";
        String member2 = "Raj";
        String member3 = "Vinay Kumar";
 
        //get a jedis connection jedis connection pool
        Jedis jedis = pool.getResource();
        try {
            //save to redis
            jedis.sadd(key, member1, member2, member3);
 
            //after saving the data, lets retrieve them to be sure that it has really added in redis
            Set<String> members = jedis.smembers(key);
            for (String member : members) {
                log.info(member);
            }
        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            ///it's important to return the Jedis instance to the pool once you've finished using it
            if (null != jedis)
                pool.returnResource(jedis);
        }
    }
 
    public void addHash() {
        //add some values in Redis HASH
        String key = "ecom";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Flip Kart");
        map.put("domain", "www.flipkart.com");
        map.put("description", "Online gift portal");
 
        Jedis jedis = pool.getResource();
        try {
            //save to redis
        	jedis.hmset(key, map);
 
            //after saving the data, lets retrieve them to be sure that it has really added in redis
            Map<String, String> retrieveMap = jedis.hgetAll(key);
            for (String keyMap : retrieveMap.keySet()) {
                log.info(keyMap + " " + retrieveMap.get(keyMap));
            }
 
        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            ///it's important to return the Jedis instance to the pool once you've finished using it
            if (null != jedis)
                pool.returnResource(jedis);
        }
    }
 
    public static void main(String[] args){
        JedisMain main = new JedisMain();
        main.addSets();
        main.addHash();
    }
}