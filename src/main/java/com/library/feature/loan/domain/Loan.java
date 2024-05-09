package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.user.domain.User;

public class Loan {

    public final String id, loanDate, returnDate;

    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String loanDate, User user,
                DigitalBook digitalBook) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = null;
        this.user = user;
        this.digitalBook = digitalBook;
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
