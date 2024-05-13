package com.library.feature.loan.domain;

public class UpdateReturnDateLoanUseCase {

    private LoanRepository loanRepository;

    public UpdateReturnDateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        loanRepository.updateReturnDateLoan(loan);
    }
}
