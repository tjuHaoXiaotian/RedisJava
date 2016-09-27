package cn.edu.tju.scs;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Created by haoxiaotian on 2016/9/25 1:15.
 */
public class RedisZSet {

    public static void main(String [] args){
        Jedis jedis = new Jedis("localhost");

        jedis.zadd("zset-key",90,"数学");
        jedis.zadd("zset-key",80,"算法");
        jedis.zadd("zset-key",70,"网络");

        Set<String> zset = jedis.zrange("zset-key",0,-1);
        for(String s:zset){
            System.out.println(s);
        }

        System.out.println("zrange by score: ");
        Set<String> members = jedis.zrangeByScore("zset-key",70,80);
        for(String s:members){
            System.out.println(s);
        }

        jedis.zrem("zset-key","网络");

        System.out.println("zrange with score: ");
        Set<Tuple> zset2 = jedis.zrangeWithScores("zset-key", 0, -1);
        for(Tuple t:zset2){
            System.out.println(t.getElement());
            System.out.println(t.getScore());

        }
        jedis.del("zset-key");
    }
}
