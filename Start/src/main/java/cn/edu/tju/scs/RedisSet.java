package cn.edu.tju.scs;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by haoxiaotian on 2016/9/25 0:53.
 */
public class RedisSet {

    public static void main(String args[]){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        jedis.sadd("set-key","item");
        jedis.sadd("set-key","item2");
        jedis.sadd("set-key","item3");
        Long result = jedis.sadd("set-key","item");
        System.out.println("add result:"+result);

        Set<String> sets0 = jedis.smembers("set-key");
        System.out.println("sets :");
        for(String s:sets0){
            System.out.println(s);
        }
        System.out.println("is member: " + jedis.sismember("set-key", "item"));

        jedis.srem("set-key","item");

        Set<String> sets = jedis.smembers("set-key");
        System.out.println("after remove : ");
        for(String s:sets){
            System.out.println(s);
        }

        Set<String> keys = jedis.keys("*");
        System.out.println("keys * ");
        for(String s:keys){
            System.out.println("key :  "+ s);
        }

        jedis.del("set-key");
    }
}
