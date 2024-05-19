package com.library.feature.loan.data;


import com.library.feature.loan.data.local.LoanLocalDataSource;
import com.library.feature.loan.domain.Loan;
import com.library.feature.loan.domain.LoanRepository;

import java.util.List;

public class LoanDataRepository implements LoanRepository {

    private final LoanLocalDataSource loanLocalDataSource;

    public LoanDataRepository(LoanLocalDataSource loanLocalDataSource) {
        this.loanLocalDataSource = loanLocalDataSource;
    }

    @Override
    public void saveLoan(Loan loan) {
        loanLocalDataSource.save(loan);
    }

    @Override
    public void deleteLoan(String id) {
        loanLocalDataSource.delete(id);
    }

    @Override
    public List<Loan> getLoans() {
        return loanLocalDataSource.findAll();
    }

    @Override
    public Loan getLoan(String id) {
        return loanLocalDataSource.findById(id);
    }

    @Override
    public void returnALoan(Loan loan) {
        loanLocalDataSource.returnALoan(loan);
    }

}
