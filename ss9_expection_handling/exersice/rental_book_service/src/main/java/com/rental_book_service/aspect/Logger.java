package com.rental_book_service.aspect;

import com.rental_book_service.model.RentalBook;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Aspect
@Component
public class Logger {
    private static final String PATH = "C:\\CodeGym\\Module_4\\ss9_expection_handling\\exersice\\rental_book_service\\src\\main\\java\\com\\rental_book_service\\data\\history.txt";

    @AfterReturning(value = "execution(* com.rental_book_service.controller.BookController.saveNewBook*(..))")
    public void loggerAddNewBook() {
        writeToFile("Them moi sach vao luc: " + new Date() + "\n");
    }

    @AfterReturning(value = "execution(* com.rental_book_service.controller.BookController.rentBook*(..))", returning = "result")
    public void loggerRentBook(Object result) {
        RentalBook rentalBook = (RentalBook) ((ModelAndView) result).getModel().get("rentalBook");
        writeToFile("Sach " + rentalBook.getBook().getNameBook() + " duoc thue \n");
    }

    @AfterReturning(value = "execution(* com.rental_book_service.controller.BookController.payBook*(..))")
    public void loggerPayBook() {
        writeToFile("Nguoi thue da tra sach\n");
    }

    @After(value = "execution(* com.rental_book_service.controller.BookController.*(..))")
    public void loggerUserGoToLibrary(JoinPoint joinPoint) {
        String action = joinPoint.getSignature().getName();
        if (action.equals("rentBook")) writeToFile("Co nguoi vao thue sach \n");
        if (action.equals("payBook")) writeToFile("Co nguoi vao tra sach \n");
    }

    public void writeToFile(String message) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(PATH, true));
            bufferedWriter.write(message);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
