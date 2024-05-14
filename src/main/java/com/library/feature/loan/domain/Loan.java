package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.user.domain.User;


public class Loan {

    public final String id, loanDate, returnDate, loanStatus, estimatedReturnDate;

    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String loanDate, String returnDate, String loanStatus,
                String estimatedReturnDate, User user, DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.estimatedReturnDate = estimatedReturnDate;
        this.user = user;
        this.digitalBook = digitalBook;
    }

    public Loan updateReturnDate_LoanStatus(String returnDate, String loanStatus) {
        return new Loan(this.id, this.loanDate, returnDate, loanStatus,
                this.estimatedReturnDate, this.user, this.digitalBook);
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
