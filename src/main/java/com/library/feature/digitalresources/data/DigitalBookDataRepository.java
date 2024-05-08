package com.library.feature.digitalresources.data;

import com.library.feature.digitalresources.data.local.DigitalBookLocalDataSource;
import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.digitalresources.domain.digitalbook.DigitalBookRepository;

import java.util.List;

public class DigitalBookDataRepository implements DigitalBookRepository {

    private final DigitalBookLocalDataSource digitalBookLocalDataSource;

    public DigitalBookDataRepository(DigitalBookLocalDataSource digitalBookLocalDataSource) {
        this.digitalBookLocalDataSource = digitalBookLocalDataSource;
    }

    @Override
    public void createDigitalBook(DigitalBook digitalBook) {
        digitalBookLocalDataSource.save(digitalBook);
    }

    @Override
    public void deleteDigitalBook(String id) {
        digitalBookLocalDataSource.delete(id);
    }

    @Override
    public void updateDigitalBook(DigitalBook digitalBook) {
        digitalBookLocalDataSource.updateDigitalBook(digitalBook);
    }

    @Override
    public List<DigitalBook> getDigitalBooks() {
        return digitalBookLocalDataSource.findAll();
    }
}
