package com.library.feature.loan.domain;

public class CreateLoanUseCase {

    private LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        loanRepository.createLoan(loan);
    }
}
