package service;

import dao.LibDaoImpl;
import model.Book;
import model.Category;
import model.User;

import java.util.List;

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
    public void addBookCategory(String id, String categoryName){
        if (!categoryIsExist(id, categoryName)){
            libDao.addBookCategory(id, categoryName);
        }
    }
    public boolean categoryIsExist(String id, String categoryName) {
        List<Category> list=libDao.getAllBookCategory();
                for (int i=0;i<list.size();i++){
                    Category category=list.get(i);
                    if(category.getId().equals(id)){
                        return true;
                    }
                    if(category.getName().equals(categoryName)){
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


    public List<Category> getAllBookCategory(){
        return libDao.getAllBookCategory();
    }
    public void addBook(Book book){
        libDao.addBook(book);
    }
    public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName){
       return libDao.getBooksByCondition(bookID,bookName,categoryName);
    }
}
