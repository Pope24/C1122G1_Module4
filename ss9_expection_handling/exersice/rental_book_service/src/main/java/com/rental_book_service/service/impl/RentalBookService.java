package com.rental_book_service.service.impl;

import com.rental_book_service.model.Book;
import com.rental_book_service.model.RentalBook;
import com.rental_book_service.repository.IRentalBookRepository;
import com.rental_book_service.service.IRentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalBookService implements IRentalBookService {
    @Autowired
    private IRentalBookRepository rentalBookRepository;
    @Override
    public void save(RentalBook rentalBook) {
        rentalBookRepository.save(rentalBook);
    }

    @Override
    public List<RentalBook> findAll() {
        return (List<RentalBook>) rentalBookRepository.findAll();
    }

    @Override
    public Optional<RentalBook> findById(Long id) {
        return rentalBookRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        rentalBookRepository.deleteById(id);
    }
}
