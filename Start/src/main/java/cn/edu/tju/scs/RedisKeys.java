package cn.edu.tju.scs;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by haoxiaotian on 2016/9/25 1:01.
 */
public class RedisKeys {
    public static void main(String args[]){
        Jedis jedis = new Jedis("localhost");
        jedis.hset("hash-key","sub-key1","value1");
        jedis.hset("hash-key","sub-key2","value2");
        jedis.hset("hash-key","sub-key3","value3");
        jedis.hset("hash-key","sub-key4","value4");

        Map<String,String> hkeys = jedis.hgetAll("hash-key");
        for(String s:hkeys.keySet()){
            System.out.println(s+" ——> "+hkeys.get(s));
        }

        jedis.hdel("hash-key","sub-key1");

        System.out.println("sub-key2 : " + jedis.hget("hash-key", "sub-key2"));

        Map<String,String> hkeys2 = jedis.hgetAll("hash-key");
        for(String s:hkeys2.keySet()){
            System.out.println(s+" ——> "+hkeys.get(s));
        }

        jedis.del("hash-key");
    }
}
