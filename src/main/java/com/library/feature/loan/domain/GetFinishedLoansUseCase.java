package com.library.feature.loan.domain;

import java.util.List;

public class GetFinishedLoansUseCase {

    private LoanRepository loanRepository;

    public GetFinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        return loanRepository.getLoansFinished();
    }
}
