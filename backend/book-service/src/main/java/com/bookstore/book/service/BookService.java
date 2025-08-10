package com.bookstore.book.service;

import com.bookstore.book.model.Book;
import com.bookstore.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book save(Book book) {
        return repo.save(book);
    }
}