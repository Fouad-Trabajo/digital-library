package com.library.feature.digitalresources.data;

import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.digitalresources.domain.DigitalBookRepository;

import java.util.List;

public class DigitalBookDataRepository implements DigitalBookRepository {

    private DigitalBookFileLocalDataSource digitalBookFileLocalDataSource;

    public DigitalBookDataRepository(DigitalBookFileLocalDataSource digitalBookFileLocalDataSource) {
        this.digitalBookFileLocalDataSource = digitalBookFileLocalDataSource;
    }

    @Override
    public void createDigitalBook(DigitalBook digitalBook) {
        digitalBookFileLocalDataSource.save(digitalBook);
    }

    @Override
    public void deleteDigitalBook(String id) {
        digitalBookFileLocalDataSource.delete(id);
    }

    @Override
    public void updateDigitalBook(DigitalBook digitalBook) {
        digitalBookFileLocalDataSource.updateDigitalBook(digitalBook);
    }

    @Override
    public List<DigitalBook> getDigitalBooks() {
        return digitalBookFileLocalDataSource.findAll();
    }
}
