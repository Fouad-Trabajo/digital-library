package com.library.feature.loan.domain;

import java.util.List;

public class GetLoansUseCase {

    private LoanRepository loanRepository;

    public GetLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute(){
        return loanRepository.getLoans();
    }
}
