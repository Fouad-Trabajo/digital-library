package com.library.feature.loan.data;


import com.library.feature.loan.data.local.LoanLocalDataSource;
import com.library.feature.loan.domain.Loan;
import com.library.feature.loan.domain.LoanRepository;

import java.util.List;

public class LoanDataRepository implements LoanRepository {

    private LoanLocalDataSource loanLocalDataSource;

    public LoanDataRepository(LoanLocalDataSource loanFileLocalDataSource) {
        this.loanLocalDataSource = loanFileLocalDataSource;
    }

    @Override
    public void createLoan(Loan loan) {
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
    public void updateLoan(Loan loan) {
        loanLocalDataSource.updateLoan(loan);
    }
}
