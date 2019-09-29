package dao;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl {
    private static final List<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
    }
    public void updateBook(Book book) {
        if(getBookByBookId(book.getId())!=null){
            Book oldBook=getBookByBookId(book.getId());
            books.remove(oldBook);
            books.add(book);
        }
    }
    public void deleteBook(String bookId) {
        if(getBookByBookId(bookId)!=null){
            Book book=getBookByBookId(bookId);
            books.remove(book);
        }
    }
    public Book getBookByBookId(String bookID) {
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getId().equals(bookID)){
                return books.get(i);
            }
        }
        return null;
    }
    public List<Book> getBooksByCategoryName(String categoryName) {
        List bookList=new ArrayList();
        bookList.clear();
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getCategory().getName().equals(categoryName)){
                bookList.add(books.get(i));
            }
        }
        return bookList;
    }

    public static List<Book> getBooks() {
        return books;
    }
}
