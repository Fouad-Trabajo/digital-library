package com.library.feature.loan.domain;


public class SaveLoanUseCase {

    private LoanRepository loanRepository;

    public SaveLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public void execute(Loan loan) {
        loanRepository.saveLoan(loan);
    }

}


