package com.library.feature.loan.domain;

public class UpdateLoanUseCase {

    private LoanRepository loanRepository;

    public UpdateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        loanRepository.updateLoan(loan);
    }
}
