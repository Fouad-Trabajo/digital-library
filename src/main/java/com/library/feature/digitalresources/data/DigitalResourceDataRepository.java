package com.library.feature.digitalresources.data;

import com.library.feature.digitalresources.data.local.DigitalResourceLocalDataSource;
import com.library.feature.digitalresources.domain.DigitalResourceRepository;
import com.library.feature.digitalresources.domain.DigitalResources;

import java.util.List;

public class DigitalResourceDataRepository implements DigitalResourceRepository {

    private final DigitalResourceLocalDataSource digitalResourceLocalDataSource;

    public DigitalResourceDataRepository(DigitalResourceLocalDataSource digitalResourceLocalDataSource) {
        this.digitalResourceLocalDataSource = digitalResourceLocalDataSource;
    }


    @Override
    public void createDigitalResource(DigitalResources digitalResources) {
        digitalResourceLocalDataSource.save(digitalResources);
    }

    @Override
    public void deleteDigitalResource(String id) {
        digitalResourceLocalDataSource.findById(id);
    }

    @Override
    public void updateDigitalResource(DigitalResources digitalResources) {
        digitalResourceLocalDataSource.updateDigitalResource(digitalResources);
    }

    @Override
    public List<DigitalResources> getDigitalResources() {
        return digitalResourceLocalDataSource.findAll();
    }

    @Override
    public DigitalResources getDigitalResource(String id) {
        return digitalResourceLocalDataSource.findById(id);
    }
}
