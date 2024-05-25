package com.library.feature.loan.domain;

import com.library.feature.loan.data.LoanDataRepository;
import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.data.local.LoanLocalDataSource;

public class LoanFactory {

    private final LoanLocalDataSource loanLocalDataSource = new LoanFileLocalDataSource();

   private final LoanRepository loanRepository = new LoanDataRepository(loanLocalDataSource);

   public SaveLoanUseCase buildSaveLoan(){
       return new SaveLoanUseCase(loanRepository);
   }

   public DeleteLoanUseCase buildDeleteLoan(){
       return new DeleteLoanUseCase(loanRepository);
   }

   public GetLoansUseCase buildGetLoans(){
       return new GetLoansUseCase(loanRepository);
   }

   public GetLoanUseCase buildGetLoan(){
       return new GetLoanUseCase(loanRepository);
   }

   public ReturnALoanUseCase buildReturnALoan(){
       return new ReturnALoanUseCase(loanRepository);
   }

   public GetFinishedLoansUseCase buildGetFinishedLoans(){
       return new GetFinishedLoansUseCase(loanRepository);
   }

    public GetLoansActiveUseCase buildGetActiveLoans(){
        return new GetLoansActiveUseCase(loanRepository);
    }

}
