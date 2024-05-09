package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.user.domain.User;

public class Loan {

    public final String id, loanDate;
    public String returnDate;

    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String loanDate, String returnDate, User user,
                DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.user = user;
        this.digitalBook = digitalBook;
    }


    public boolean isActive() {
        return returnDate == null;
    }


    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", loanDate='" + loanDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", user=" + user +
                ", digitalBook=" + digitalBook +
                '}' + "'\n";
    }
}
