//业务层
package com.jinli.service;
import com.jinli.dao.UserDao;
import com.jinli.dao.UserDaoImpl;
import com.jinli.dao.UserDaoMysql;

public class UserserviceImpl implements UserService {
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysql();
    private UserDao userDao;//设置接口
    //利用set动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser(); //调接口里面的方法
    }
}
