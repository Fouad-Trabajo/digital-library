package com.library.feature.demo.data;

import com.library.feature.demo.domain.Demo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DemoMemLocalDataSource {
    private Map<String, Demo> dataStore = new TreeMap<>();

    public void save(Demo model) {
        dataStore.put(model.getId(), model);
    }

    public void saveList(List<Demo> models) {
        for (Demo demo : models) {
            save(demo);
        }
    }

    public Demo findById(String id) {
        return dataStore.get(id);
    }

    public List<Demo> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelId) {
        dataStore.remove(modelId);
    }
}
