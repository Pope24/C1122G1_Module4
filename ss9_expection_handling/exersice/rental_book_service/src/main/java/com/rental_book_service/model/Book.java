package com.rental_book_service.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String nameBook;
    private int amount;
    @Embedded
    private InitialDate initialDate;

    public Book() {
        initialDate = new InitialDate();
    }

    public Book(int id, String description, String nameBook, int amount, InitialDate initialDate) {
        this.id = id;
        this.description = description;
        this.nameBook = nameBook;
        this.amount = amount;
        this.initialDate = initialDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public InitialDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(InitialDate initialDate) {
        this.initialDate = initialDate;
    }
}
