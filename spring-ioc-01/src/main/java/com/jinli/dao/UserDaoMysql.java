package com.jinli.dao;

public class UserDaoMysql implements UserDao{
    @Override
    public void getUser() {
        System.out.println("默认获取mysql用户的数据");
    }
}
