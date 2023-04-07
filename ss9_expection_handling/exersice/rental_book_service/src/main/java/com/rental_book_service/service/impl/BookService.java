package com.rental_book_service.service.impl;

import com.rental_book_service.model.Book;
import com.rental_book_service.repository.IBookRepository;
import com.rental_book_service.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void rentBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void payBook(Book book) {
        bookRepository.save(book);
    }
}
