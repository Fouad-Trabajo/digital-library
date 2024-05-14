package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.user.domain.User;


public class Loan {

    public final String id, loanDate, returnDate, loanStatus;

    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String loanDate, String returnDate, String loanStatus,
                User user, DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.user = user;
        this.digitalBook = digitalBook;
    }

    public Loan updateReturnDate_LoanStatus(String returnDate, String loanStatus) {
        return new Loan(this.id, this.loanDate, returnDate, loanStatus,
                this.user, this.digitalBook);
    }


    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", loanDate='" + loanDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", loanStatus=" + loanStatus +
                ", user=" + user +
                ", digitalBook=" + digitalBook +
                '}' + "'\n";
    }
}
