package com.rental_book_service.model;

import javax.persistence.*;

@Entity
public class RentalBook {
    @Id
    private Long id;
    @ManyToOne
    private Book book;

    public RentalBook() {
    }

    public RentalBook(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
