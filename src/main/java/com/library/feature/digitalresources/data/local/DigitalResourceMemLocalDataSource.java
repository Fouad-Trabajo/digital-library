package com.library.feature.digitalresources.data.local;


import com.library.feature.digitalresources.domain.DigitalResources;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DigitalResourceMemLocalDataSource implements DigitalResourceLocalDataSource {

    private static DigitalResourceMemLocalDataSource instance = null;

    public static DigitalResourceMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new DigitalResourceMemLocalDataSource();
        }
        return instance;
    }

    private DigitalResourceMemLocalDataSource() {

    }

    private Map<String, DigitalResources> dataStore = new TreeMap<>();

    @Override
    public void save(DigitalResources model) {
        dataStore.put(model.id, model);
    }

    @Override
    public void saveList(List<DigitalResources> models) {
        for (DigitalResources demo : models) {
            save(demo);
        }
    }

    @Override
    public DigitalResources findById(String id) {
        return dataStore.get(id);
    }

    @Override
    public List<DigitalResources> findAll() {
        return dataStore.values().stream().toList();
    }

    @Override
    public void delete(String modelId) {
        dataStore.remove(modelId);
    }

    @Override
    public void updateDigitalResource(DigitalResources model) {
        // Comprueba si el libro digital existe en el almacén de datos
        DigitalResources existingModel = dataStore.get(model.id);

        if (existingModel != null) {
            // Si el libro existe, actualiza el libro en el almacén de datos
            dataStore.put(model.id, model);
        } else {
            // Si el libro no existe, imprime un mensaje de error
            System.out.println("No se puede actualizar. El libro digital con el ID " + model.id + " no existe.");
        }
    }
}
