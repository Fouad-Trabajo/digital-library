package com.library.feature.loan.data.local;

import com.library.feature.loan.domain.Loan;

import java.util.List;

public interface LoanLocalDataSource {

    void save(Loan model);

    void saveList(List<Loan> models);

    Loan findById(String id);

    List<Loan> findAll();

    void delete(String modelId);

    void updateLoan(Loan updateModel);

    void update2(Loan updateModel);

    List<Loan> getLoansActive();

    List<Loan> getFinishedLoans();
}
