import com.jinli.dao.UserDaoImpl;
import com.jinli.dao.UserDaoMysql;
import com.jinli.service.UserserviceImpl;

public class Mytest {
    public static void main(String[] args) {
        //new对象快捷键.var
        //用户实际调用的是service层，dao层他们不需要接触
        UserserviceImpl userservice = new UserserviceImpl();
        userservice.setUserDao(new UserDaoImpl());
        userservice.getUser();

    }

}
