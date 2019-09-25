package service;

import dao.LibDaoImpl;

public class UserServiceImpl {
    LibDaoImpl libDao=new LibDaoImpl();

    public int isLogin(String username, String password){
        if(libDao.login(username,password)==1){
            return 1;
        }else
        {
            return 0;
        }
    }
}
