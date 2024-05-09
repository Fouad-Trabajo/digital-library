package com.library.feature.loan.data.local;


import com.library.feature.loan.domain.Loan;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LoanMemLocalDataSource implements LoanLocalDataSource {

    private static LoanMemLocalDataSource instance = null;

    public static LoanMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new LoanMemLocalDataSource();
        }
        return instance;
    }

    private LoanMemLocalDataSource() {

    }

    private Map<String, Loan> dataStore = new TreeMap<>();

    @Override
    public void save(Loan model) {
        dataStore.put(model.id, model);
    }

    @Override
    public void saveList(List<Loan> models) {
        for (Loan demo : models) {
            save(demo);
        }
    }

    @Override
    public Loan findById(String id) {
        return dataStore.get(id);
    }

    @Override
    public List<Loan> findAll() {
        return dataStore.values().stream().toList();
    }

    @Override
    public void delete(String modelId) {
        dataStore.remove(modelId);
    }

    @Override
    public void updateLoan(Loan model) {
        // Comprueba si el libro digital existe en el almacén de datos
        Loan existingModel = dataStore.get(model.id);

        if (existingModel != null) {
            // Si el libro existe, actualiza el libro en el almacén de datos
            dataStore.put(model.id, model);
        } else {
            // Si el libro no existe, imprime un mensaje de error
            System.out.println("No se puede actualizar. El libro digital con el ID " + model.id + " no existe.");
        }
    }

    @Override
    public void update2(Loan updateModel) {

    }

    @Override
    public List<Loan> getLoansActive() {
        List<Loan> loans = findAll();
        List<Loan> loansActive = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isActive()) {
                loansActive.add(loan);
            }
        }
        return loansActive;
    }

    @Override
    public List<Loan> getFinishedLoans() {
        List<Loan> loans = findAll();
        List<Loan> loanFinished = new ArrayList<>();
        for (Loan loan : loans) {
            if (!loan.isActive()) {
                loanFinished.add(loan);
            }
        }
        return loanFinished;
    }


}
