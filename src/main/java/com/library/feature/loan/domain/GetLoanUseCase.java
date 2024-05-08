package com.library.feature.loan.domain;

public class GetLoanUseCase {

    private LoanRepository loanRepository;

    public GetLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute(String id) {
        return loanRepository.getLoan(id);
    }
}
