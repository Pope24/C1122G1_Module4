package com.rental_book_service.service;

import com.rental_book_service.model.Book;
import com.rental_book_service.model.RentalBook;

import java.util.List;
import java.util.Optional;

public interface IRentalBookService {
    void save(RentalBook rentalBook);
    List<RentalBook> findAll();
    Optional<RentalBook> findById(Long id);
    void remove(Long id);
}
