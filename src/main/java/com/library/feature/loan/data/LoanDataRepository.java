package com.library.feature.loan.data;

import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.LoanRepository;

public class LoanDataRepository implements LoanRepository {

    private LoanFileLocalDataSource loanFileLocalDataSource;

    public LoanDataRepository(LoanFileLocalDataSource loanFileLocalDataSource) {
        this.loanFileLocalDataSource = loanFileLocalDataSource;
    }
}
