package com.library.feature.digitalresources.data;

import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.digitalresources.domain.DigitalBookRepository;

public class DigitalBookDataRepository implements DigitalBookRepository {

    private DigitalBookFileLocalDataSource digitalBookFileLocalDataSource;

    public DigitalBookDataRepository(DigitalBookFileLocalDataSource digitalBookFileLocalDataSource) {
        this.digitalBookFileLocalDataSource = digitalBookFileLocalDataSource;
    }

    @Override
    public void createDigitalBook(DigitalBook digitalBook) {
        digitalBookFileLocalDataSource.save(digitalBook);
    }
}
