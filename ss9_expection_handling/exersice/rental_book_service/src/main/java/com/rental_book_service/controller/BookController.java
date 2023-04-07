package com.rental_book_service.controller;

import com.rental_book_service.model.Book;
import com.rental_book_service.model.RentalBook;
import com.rental_book_service.service.IBookService;
import com.rental_book_service.service.IRentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRentalBookService rentalBookService;

    @GetMapping("")
    public ModelAndView showListBook() {
        ModelAndView modelAndView = new ModelAndView("listBook");
        modelAndView.addObject("bookList", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showFormCreateBook() {
        ModelAndView modelAndView = new ModelAndView("formCreate");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("create-book/save")
    public String saveNewBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("rent-book/{id}")
    public ModelAndView rentBook(@PathVariable int id) {
        Book book = bookService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detailRental");
        RentalBook rentalBook = new RentalBook();
        rentalBook.setId(Math.round(Math.random() * 89999) + 10000);
        rentalBook.setBook(book);
        book.setAmount(book.getAmount() - 1);
        bookService.save(book);
        rentalBookService.save(rentalBook);
        modelAndView.addObject("rentalBook", rentalBook);
        return modelAndView;
    }

    @PostMapping("pay-book")
    public String payBook(@RequestParam Long id) {
        RentalBook rentalBook = rentalBookService.findById(id).get();
        if (rentalBook == null) {
            return "redirect:/error";
        }
        Book book = bookService.findById(rentalBook.getBook().getId()).get();
        book.setAmount(book.getAmount() + 1);
        bookService.save(book);
        rentalBookService.remove(id);
        return "redirect:/";
    }
}
