package com.library.feature.loan.domain;

public interface LoanRepository {
    void createLoan(Loan loan);

    void deleteLoan(String id);
}
