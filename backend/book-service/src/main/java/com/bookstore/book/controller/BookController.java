package com.bookstore.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.book.dto.BookDTO;
import com.bookstore.book.model.Book;
import com.bookstore.book.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        List<Book> books = service.getAll();
        List<BookDTO> dtos = books.stream().map(book -> {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setPrice(book.getPrice());
            return dto;
        }).toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        Book saved = service.save(book);

        dto.setId(saved.getId());
        return ResponseEntity.ok(dto);
    }
}