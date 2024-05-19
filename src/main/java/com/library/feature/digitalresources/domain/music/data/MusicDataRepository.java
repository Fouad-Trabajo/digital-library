package com.library.feature.digitalresources.domain.music.data;

import com.library.feature.digitalresources.domain.DigitalResourceRepository;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.domain.music.data.local.MusicLocalDataSource;

import java.util.List;

public class MusicDataRepository implements DigitalResourceRepository {

    private MusicLocalDataSource musicLocalDataSource;

    public MusicDataRepository(MusicLocalDataSource musicLocalDataSource) {
        this.musicLocalDataSource = musicLocalDataSource;
    }

    @Override
    public void createDigitalResource(DigitalResources digitalResources) {

    }

    @Override
    public void deleteDigitalResource(String id) {

    }

    @Override
    public void updateDigitalResource(DigitalResources digitalResources) {

    }

    @Override
    public List<DigitalResources> getDigitalResources() {
        return null;
    }

    @Override
    public DigitalResources getDigitalResource(String id) {
        return null;
    }
}
