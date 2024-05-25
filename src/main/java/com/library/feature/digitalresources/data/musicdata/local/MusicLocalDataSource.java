package com.library.feature.digitalresources.data.musicdata.local;


import com.library.feature.digitalresources.domain.music.domain.Music;

import java.util.List;

public interface MusicLocalDataSource {


    void save(Music model);

    void saveList(List<Music> models);

    Music findById(String id);

    List<Music> findAll();

    void delete(String modelId);

    void updateMusic(Music updateMusic);
}
