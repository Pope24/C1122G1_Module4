package com.rental_book_service.service;

import com.rental_book_service.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();
    Optional<Book> findById(int id);
    void save(Book book);
    void rentBook(Book book);
    void payBook(Book book);
}
