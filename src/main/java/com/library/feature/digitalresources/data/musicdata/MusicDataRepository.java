package com.library.feature.digitalresources.data.musicdata;

import com.library.feature.digitalresources.domain.DigitalResourceRepository;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.data.musicdata.local.MusicLocalDataSource;
import com.library.feature.digitalresources.domain.music.domain.Music;

import java.util.List;
import java.util.stream.Collectors;

public class MusicDataRepository implements DigitalResourceRepository {

    private MusicLocalDataSource musicLocalDataSource;

    public MusicDataRepository(MusicLocalDataSource musicLocalDataSource) {
        this.musicLocalDataSource = musicLocalDataSource;
    }

    @Override
    public void createDigitalResource(DigitalResources digitalResources) {
        musicLocalDataSource.save((Music) digitalResources);
    }

    @Override
    public void deleteDigitalResource(String id) {
        musicLocalDataSource.delete(id);

    }

    @Override
    public void updateDigitalResource(DigitalResources digitalResources) {
        musicLocalDataSource.updateMusic((Music) digitalResources);
    }

    @Override
    public List<DigitalResources> getDigitalResources() {
        return musicLocalDataSource.findAll()
                .stream()
                .map(music -> (Music) music)
                .collect(Collectors.toList());
    }

    @Override
    public DigitalResources getDigitalResource(String id) {
        return musicLocalDataSource.findById(id);
    }
}
