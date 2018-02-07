package com.csx.springtest.example3.dynamic;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/07
 */
public class UserService {
    private UserDao  userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
