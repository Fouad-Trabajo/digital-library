package com.library.feature.loan.domain;

public class ReturnALoanUseCase {

    private LoanRepository loanRepository;

    public ReturnALoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(String id){
        Loan loan = loanRepository.getLoan(id);

        Loan updatedLoan = new Loan(loan.id, loan.loanDate,
                loan.estimatedReturnDate, loan.user, loan.digitalResources);
        loanRepository.returnALoan(updatedLoan);
    }
}
