package com.library.feature.digitalresources.domain.digitalbook.data;

import com.library.feature.digitalresources.domain.DigitalResourceRepository;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.domain.digitalbook.data.local.DigitalBookLocalDataSource;
import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;

import java.util.List;
import java.util.stream.Collectors;

public class DigitalBookDataRepository implements DigitalResourceRepository {

    private  DigitalBookLocalDataSource digitalBookLocalDataSource;

    public DigitalBookDataRepository(DigitalBookLocalDataSource digitalBookLocalDataSource) {
        this.digitalBookLocalDataSource = digitalBookLocalDataSource;
    }


    @Override
    public void createDigitalResource(DigitalResources digitalResources) {
        digitalBookLocalDataSource.save((DigitalBook) digitalResources);
    }

    @Override
    public void deleteDigitalResource(String id) {
        digitalBookLocalDataSource.delete(id);
    }

    @Override
    public void updateDigitalResource(DigitalResources digitalResources) {
            digitalBookLocalDataSource.updateDigitalBook((DigitalBook) digitalResources);
    }

    @Override
    public List<DigitalResources> getDigitalResources() {
        return digitalBookLocalDataSource.findAll()
                .stream()
                .map(digitalBook -> (DigitalResources) digitalBook)
                .collect(Collectors.toList());
    }
    @Override
    public DigitalResources getDigitalResource(String id) {
        return digitalBookLocalDataSource.findById(id);
    }
}
