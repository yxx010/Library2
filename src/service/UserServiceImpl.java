package service;

import dao.UserDaoImpl;
import model.User;

import java.util.List;

public class UserServiceImpl {
    UserDaoImpl userDao=new UserDaoImpl();

    public boolean isLogin(String username, String password){
        if(userDao.login(username,password)==1){
            return true;
        }else
        {
            return false;
        }
    }
    public boolean userIsExist(String username){
        List<User> list=userDao.getUserDb();
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getName().equals(username)){
                return true;
            }
        }
        return false;
    }
}
