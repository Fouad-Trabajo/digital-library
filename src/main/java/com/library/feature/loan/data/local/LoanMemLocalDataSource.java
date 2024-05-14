package com.library.feature.loan.data.local;


import com.library.feature.loan.domain.Loan;




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
}
