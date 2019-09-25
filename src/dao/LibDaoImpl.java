package dao;

import model.Book;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibDaoImpl {
    private static final List<User> userDb = new ArrayList<>();
    private static final List<Map<String, Object>> categorys = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();


    public void regist(User user) {
            userDb.add(user);
    }

    public int login(String username, String password) {
        if (userDb != null) {
            for (int i = 0; i < userDb.size(); i++) {
                if (userDb.get(0).getName().equals(username)) {
                    if (userDb.get(0).getPassword().equals(password)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void addBookCategory(Long id, String categoryName, String description) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("categoryName", categoryName);
        map.put("description", description);
        categorys.add(map);
    }

    public List<Map<String, Object>> getAllBookCategory() {

        return categorys;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public static List<User> getUserDb() {
        return userDb;
    }

    public static List<Map<String, Object>> getCategorys() {
        return categorys;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public List<Book> getBooksByCondition(String bookID, String bookName, String categoryName) {
        //books.clear();
        //books.add(new Book("1","管理者","经管","100","很好看"));
        //books.add(new Book("2","高效","职场","100","很好看"));
        List<Book> bookList = new ArrayList<>();
        for (int i=0;i<books.size();i++){
            bookList.add(books.get(i));
        }
        if (bookID != null) {
            if (!bookID.isEmpty()) {
                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    if (!book.getId().equals(bookID)) {
                        bookList.remove(book);
                        i--;
                    }
                }
            }
        }
        if (bookName != null) {
            if (!bookName.isEmpty()) {
                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    if (!book.getName().equals(bookName)) {
                        bookList.remove(book);
                        i--;
                    }
                }
            }
        }
        if (categoryName != null) {
            if (!categoryName.isEmpty()) {
                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    if (!book.getCategory().equals(categoryName)) {
                        bookList.remove(book);
                        i--;
                    }
                }

            }
        }


        return bookList;
    }
}
