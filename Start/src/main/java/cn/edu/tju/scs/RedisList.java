package cn.edu.tju.scs;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by haoxiaotian on 2016/9/25 0:41.
 */
public class RedisList {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //存储数据到列表中
        jedis.lpush("list", "Redis");
        jedis.lpush("list", "Mongodb");
        jedis.lpush("list", "Mysql");
        jedis.rpush("list","right 1");
        jedis.lpop("list");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("list", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }
        System.out.println(jedis.lindex("list", 1));
        jedis.del("list");
    }
}
