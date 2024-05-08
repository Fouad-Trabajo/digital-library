package com.library.feature.digitalresources.data.local;


import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DigitalBookMemLocalDataSource implements DigitalBookLocalDataSource {

    private static DigitalBookMemLocalDataSource instance = null;

    public static DigitalBookMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new DigitalBookMemLocalDataSource();
        }
        return instance;
    }

    private DigitalBookMemLocalDataSource() {

    }

    private Map<String, DigitalBook> dataStore = new TreeMap<>();

    @Override
    public void save(DigitalBook model) {
        dataStore.put(model.id, model);
    }

    @Override
    public void saveList(List<DigitalBook> models) {
        for (DigitalBook demo : models) {
            save(demo);
        }
    }

    @Override
    public DigitalBook findById(String id) {
        return dataStore.get(id);
    }

    @Override
    public List<DigitalBook> findAll() {
        return dataStore.values().stream().toList();
    }

    @Override
    public void delete(String modelId) {
        dataStore.remove(modelId);
    }

    @Override
    public void updateDigitalBook(DigitalBook model) {
        // Comprueba si el libro digital existe en el almacén de datos
        DigitalBook existingModel = dataStore.get(model.id);

        if (existingModel != null) {
            // Si el libro existe, actualiza el libro en el almacén de datos
            dataStore.put(model.id, model);
        } else {
            // Si el libro no existe, imprime un mensaje de error
            System.out.println("No se puede actualizar. El libro digital con el ID " + model.id + " no existe.");
        }
    }
}
