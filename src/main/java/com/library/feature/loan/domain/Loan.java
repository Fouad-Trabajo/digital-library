package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.user.domain.User;

public class Loan {

    public final String id, startDate, endDate, laonStatus;
    public User user;
    public DigitalBook digitalBook;

    public Loan(String id, String startDate, String endDate, String laonStatus, User user,
                DigitalBook digitalBook) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.laonStatus = laonStatus;
        this.user = user;
        this.digitalBook = digitalBook;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", laonStatus='" + laonStatus + '\'' +
                ", user=" + user +
                ", digitalBook=" + digitalBook +
                '}';
    }
}
