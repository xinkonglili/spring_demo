//业务层
package com.jinli.service;
import com.jinli.dao.UserDao;
import com.jinli.dao.UserDaoImpl;
import com.jinli.dao.UserDaoMysql;
//实现类
public class UserserviceImpl implements UserService {
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysql();

    /** 实现了控制反转，之前是需要通过用户的需求更改原有的代码，现在是让用户来选择需求的对象，
    通过:
     UserserviceImpl userservice = new UserserviceImpl();
     userservice.setUserDao(new UserDaoImpl());
     来实现用户需要什么对象，就通过setUserDao()来new对象**/

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
