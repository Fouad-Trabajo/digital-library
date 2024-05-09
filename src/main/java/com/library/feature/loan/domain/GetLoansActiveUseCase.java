package com.library.feature.loan.domain;


import java.util.List;

public class GetLoansActiveUseCase {

    private LoanRepository loanRepository;

    public GetLoansActiveUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        return loanRepository.getLoansActive();
    }
}
