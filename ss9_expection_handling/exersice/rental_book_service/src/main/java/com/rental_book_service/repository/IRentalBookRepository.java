package com.rental_book_service.repository;

import com.rental_book_service.model.RentalBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalBookRepository extends PagingAndSortingRepository<RentalBook, Long> {
}
