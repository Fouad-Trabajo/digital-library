package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.user.domain.User;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Loan {

    public final String id, loanDate, returnDate, loanStatus, estimatedReturnDate;

    public User user;
    public DigitalBook digitalBook;

    //Constructor para crear el objeto Loan
    public Loan(String id, User user, DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        this.returnDate = null;
        this.loanStatus = "activo";
        this.estimatedReturnDate = LocalDateTime.now().plusDays(14).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.user = user;
        this.digitalBook = digitalBook;
    }

    //Constructor para actualizar la fecha de devolución
    public Loan(String id, String loanDate, String estimatedReturnDate, User user, DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        this.loanStatus = "finalizado";
        this.estimatedReturnDate = estimatedReturnDate;
        this.user = user;
        this.digitalBook = digitalBook;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", loanDate='" + loanDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", loanStatus=" + loanStatus +
                ", estimatedReturnDate=" + estimatedReturnDate +
                ", user=" + user +
                ", digitalBook=" + digitalBook +
                '}' + "'\n";
    }
}
