package com.library.feature.loan.domain;

import java.util.ArrayList;
import java.util.List;

public class GetLoansActiveUseCase {

    private LoanRepository loanRepository;

    public GetLoansActiveUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        List<Loan> loans = loanRepository.getLoans();
        List<Loan> loansActive = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.returnDate == null) {
                loansActive.add(loan);
            }
        }
        if (loansActive.isEmpty()){
            System.out.println("No hay préstamos vigentes. \n" +
                    "Todos los préstamos han sido devueltos");
        }
        return loansActive;
    }
}
