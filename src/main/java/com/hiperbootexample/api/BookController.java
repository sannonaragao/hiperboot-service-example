package com.hiperbootexample.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiperboot.db.domain.BasePage;
import com.hiperboot.service.HiperBootService;
import com.hiperbootexample.entity.Book;
import com.hiperbootexample.repository.BookRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class BookController
{
    @Autowired
    private BookRepository bookRepository;
    private HiperBootService<Book> hiperBootService;

    @PostConstruct
    public void initialize()
    {
        this.hiperBootService = new HiperBootService<>(bookRepository);
    }

    @PostMapping("/books-list")
    public ResponseEntity<List<Book>> getBooks(@RequestBody Map<String, Object> body)
    {
        return new ResponseEntity<>(hiperBootService.hiperBootFilter(Book.class, body), HttpStatus.OK);
    }

    @PostMapping("/books-paginated")
    public ResponseEntity<BasePage> getPaginatedBooks(@RequestBody Map<String, Object> body)
    {
        return new ResponseEntity<>(hiperBootService.hiperBootBasePageFilter(Book.class, body), HttpStatus.OK);
    }
}
