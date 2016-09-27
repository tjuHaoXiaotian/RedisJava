package cn.edu.tju.scs.service.impl;

import cn.edu.tju.scs.dao.UserDao;
import cn.edu.tju.scs.dao.cache.RedisUserDao;
import cn.edu.tju.scs.entity.User;
import cn.edu.tju.scs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by haoxiaotian on 2016/9/26 21:11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUserDao redisUserDao;

    @Override
    public boolean login(User user) {
        if(userDao.hasMatchUser(user.getUsername(),user.getPassword()) > 0){
            String token = UUID.randomUUID().toString();
            token = token.replace("-","");
            System.out.println(token);
            Long result = redisUserDao.putUser(token,user);
            System.out.println(result);

            return result == 1;
        }else{
            return false;
        }
    }

    @Override
    public boolean logout(String token) {
        long result = redisUserDao.delUser(token);
        return result == 1;
    }

    @Override
    public User getUserFromRedis(String token) {
        return redisUserDao.getUser(token);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
