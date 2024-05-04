package com.library.feature.loan.domain;

public class DeleteLoanUseCase {

    private LoanRepository loanRepository;

    public DeleteLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(String id) {
        loanRepository.deleteLoan(id);
    }
}
