package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.user.domain.User;

public class Loan {

    public final String id, startDate, endDate, loanStatus;
    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String startDate, String endDate, String loanStatus, User user,
                DigitalBook digitalBook) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanStatus = loanStatus;
        this.user = user;
        this.digitalBook = digitalBook;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", user=" + user +
                ", digitalBook=" + digitalBook +
                '}';
    }
}
