package com.library.feature.loan.domain;

import java.util.List;

public interface LoanRepository {
    void createLoan(Loan loan);

    void deleteLoan(String id);

    List<Loan> getLoans();

    void updateLoan(Loan loan);

    Loan getLoan(String id);
}
