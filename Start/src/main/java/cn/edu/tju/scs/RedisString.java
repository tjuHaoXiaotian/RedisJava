package cn.edu.tju.scs;

import redis.clients.jedis.Jedis;

/**
 * Created by haoxiaotian on 2016/9/25 0:40.
 */
public class RedisString {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.del("runoobkey");
        jedis.set("test","test");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: " + jedis.get("test"));
        jedis.del("test");
    }
}
