## 原始架构--弊端：

### 无法解耦合，每一个实现类，都要重新new一遍对象

### Dao

- UserDao

```java
package com.jinli.dao;
public interface UserDao {
    void getUser();
}

```

- <u>UserDaoImpl</u>

```java

package com.jinli.dao;

public class UserDaoImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("默认获取用户的数据"); //只需要改实现类就好了
    }
}

```

### service

-  UserService

```java
package com.jinli.service;

public interface UserService {
    void getUser();
}
```

-  UserServiceImpl

```java
//业务层
package com.jinli.service;
import com.jinli.dao.UserDao;
import com.jinli.dao.UserDaoImpl;

public class UserserviceImpl implements UserService {
//private UserDao userDao = new UserDaoImpl();
// private UserDao userDao = new UserDaoMysql();//每一个实现类，都要重新new一遍对象 //private UserDao userDao = new UserDaoImpl();// UserDao对象，业务去调dao层，实现dao层的方法

   //-----------本质区别-------利用set动态实现值的注入--------------------------------------
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
```

### test

- Mytest

```java
import com.jinli.service.UserserviceImpl;

public class Mytest {
    public static void main(String[] args) {
        //new对象快捷键.var
        //用户实际调用的是service层，dao层他们不需要接触
       // UserserviceImpl userservice = new UserserviceImpl();
         //new对象快捷键.var
        //用户实际调用的是service层，dao层他们不需要接触
      //-----------本质区别----------------------------------------------
        UserserviceImpl userservice = new UserserviceImpl();
        userservice.setUserDao(new UserDaoImpl());
      //每次只需要更改这里new的对象，不需要去动业务层了
        userservice.setUserDao(new UserserviceImpl());
        userservice.getUser();
    }

}
```

