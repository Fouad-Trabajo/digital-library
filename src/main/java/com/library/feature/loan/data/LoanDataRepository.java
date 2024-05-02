package com.library.feature.loan.data;

import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.Loan;
import com.library.feature.loan.domain.LoanRepository;

import java.util.List;

public class LoanDataRepository implements LoanRepository {

    private LoanFileLocalDataSource loanFileLocalDataSource;

    public LoanDataRepository(LoanFileLocalDataSource loanFileLocalDataSource) {
        this.loanFileLocalDataSource = loanFileLocalDataSource;
    }

    @Override
    public void createLoan(Loan loan) {
        loanFileLocalDataSource.save(loan);
    }

    @Override
    public void deleteLoan(String id) {
        loanFileLocalDataSource.delete(id);
    }

    @Override
    public List<Loan> getLoans() {
        return loanFileLocalDataSource.findAll();
    }
}
