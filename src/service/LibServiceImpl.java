package service;

import dao.LibDaoImpl;
import model.Book;
import model.User;

import java.util.List;
import java.util.Map;

public class LibServiceImpl{
    LibDaoImpl libDao=new LibDaoImpl();
    public void regist(User user){
        libDao.regist(user);
    }

    public boolean isLogin(String username, String password){
        if(libDao.login(username,password)==1){
            return true;
        }else
        {
            return false;
        }
    }
    public boolean userIsExist(String username){
        List<User> list=libDao.getUserDb();
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getName().equals(username)){
                return true;
            }
        }
        return false;
    }
    public void addBookCategory(Long id, String categoryName, String description){
        if (!categoryIsExist(id, categoryName)){
            libDao.addBookCategory(id, categoryName, description);
        }
    }
    public boolean categoryIsExist(Long id, String categoryName) {
        List<Map<String,Object>> list=libDao.getAllBookCategory();
                for (int i=0;i<list.size();i++){
                    Map<String,Object> map=list.get(i);
                    if(map.get("id").equals(id)){
                        return true;
                    }
                    if(map.get("categoryName").equals(categoryName)){
                        return true;
                    }
                }
        return false;
    }
    public boolean bookIsExist(String id, String bookName) {
        List<Book> list=libDao.getBooks();
        for (int i=0;i<list.size();i++){
            Book book=list.get(i);
            if(book.getId().equals(id)){
                return true;
            }
            if(book.getName().equals(bookName)){
                return true;
            }
        }
        return false;
    }


    public List<Map<String, Object>> getAllBookCategory(){
        return libDao.getAllBookCategory();
    }
    public void addBook(Book book){
        libDao.addBook(book);
    }
    public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName){
       return libDao.getBooksByCondition(bookID,bookName,categoryName);
    }
}
