package com.library.feature.loan.domain;

import java.util.List;

public interface LoanRepository {
    void saveLoan(Loan loan);

    void deleteLoan(String id);

    List<Loan> getLoans();

    Loan getLoan(String id);

    void returnALoan(Loan loan);
}
