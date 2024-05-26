package com.library.feature.digitalresources.data.musicdata.local;


import com.library.feature.digitalresources.data.musicdata.MusicDataRepository;
import com.library.feature.digitalresources.domain.music.domain.Music;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MusicMemLocalDataSource implements  MusicLocalDataSource{

    private static MusicMemLocalDataSource instance = null;

    public static MusicMemLocalDataSource getInstance(){
        if (instance == null){
            instance = new MusicMemLocalDataSource();
            return instance;
        }
        return null;
    }

    public MusicMemLocalDataSource() {

    }

    private Map<String, Music> dataStore = new TreeMap<>();

    public void save(Music model) {
        dataStore.put(model.id, model);
    }

    public void saveList(List<Music> models) {
        for (Music Music : models) {
            save(Music);
        }
    }

    public Music findById(String id) {
        return dataStore.get(id);
    }

    public List<Music> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }

    @Override
    public void updateMusic(Music model) {
        Music existingModel = dataStore.get(model.id);
        if (existingModel != null) {
            dataStore.put(model.id, model);
        }
    }
}
