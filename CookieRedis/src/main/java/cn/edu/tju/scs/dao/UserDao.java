package cn.edu.tju.scs.dao;

import cn.edu.tju.scs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by haoxiaotian on 2016/9/26 20:51.
 */
public interface UserDao {

    public int hasMatchUser(@Param("username")String username,@Param("password")String password);

    public List<User> getAll();

}
