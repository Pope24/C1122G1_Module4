package com.rental_book_service.repository;

import com.rental_book_service.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {

}
