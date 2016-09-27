package cn.edu.tju.scs.service;

import cn.edu.tju.scs.entity.User;

import java.util.List;

/**
 * Created by haoxiaotian on 2016/9/26 21:09.
 */
public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    public boolean login(User user);

    /**
     * 用户退出
     * @param token
     * @return
     */
    public boolean logout(String token);

    /**
     * 判断用户是否登录
     * @param token
     * @return
     */
    public User getUserFromRedis(String token);


    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAll();

}
