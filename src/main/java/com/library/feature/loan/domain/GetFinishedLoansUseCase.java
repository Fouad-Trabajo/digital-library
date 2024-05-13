package com.library.feature.loan.domain;

import java.util.ArrayList;
import java.util.List;

public class GetFinishedLoansUseCase {

    private LoanRepository loanRepository;

    public GetFinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        List<Loan> loans = loanRepository.getLoans();
        List<Loan> loansFinished = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.returnDate != null) {
                loansFinished.add(loan);
            }
        }
        if (loansFinished.isEmpty()){
            System.out.println("Todos préstamos siguen vigentes. \n" +
                    "Los libros todavía no se han devuelto");
        }
        return loansFinished;
    }
}
