package service;

import dao.BookDaoImpl;
import model.Book;

import java.util.List;

public class BookServiceImpl {
    BookDaoImpl bookDao=new BookDaoImpl();
    public void addBook(Book book) {
        bookDao.addBook(book);
    }
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
    public void deleteBook(String bookId) {
        bookDao.deleteBook(bookId);
    }
    public Book getBookByBookId(String bookID) {
       return bookDao.getBookByBookId(bookID);
    }
    public List<Book> getBooksByCategoryName(String categoryName) {
        return bookDao.getBooksByCategoryName(categoryName);
    }
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

}
