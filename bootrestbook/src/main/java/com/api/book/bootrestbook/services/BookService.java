package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//Read
    //get all books
    public List<Book> getAllBooks()
    {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id)
    {
        Book book = null;
        try{
            book = this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }
//Create
    public Book addBook(Book b)
    {
        Book result = bookRepository.save(b);
        return result;
    }

//Delete
    public void deleteBook(int bId)
    { 
       bookRepository.deleteById(bId);
    }

//Update
    public void updateBook(Book b, int bId)
    {
        b.setId(bId);
        bookRepository.save(b);
    }
}
 