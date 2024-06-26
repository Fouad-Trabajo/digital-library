package com.library.feature.user.data.local;



import com.library.feature.user.domain.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserMemLocalDataSource implements UserLocalDataSource{

    private static UserMemLocalDataSource instance= null;

    public static UserMemLocalDataSource getInstance(){
        if (instance == null){
            instance = new UserMemLocalDataSource();
        }
        return instance;
    }

    private UserMemLocalDataSource(){

    }
    private Map<String, User> dataStore = new TreeMap<>();

    @Override
    public void save(User model) {
        dataStore.put(model.id, model);
    }

    @Override
    public void saveList(List<User> models) {
        for (User demo : models) {
            save(demo);
        }
    }

    @Override
    public User findById(String id) {
        return dataStore.get(id);
    }

    @Override
    public List<User> findAll() {
        return dataStore.values().stream().toList();
    }

    @Override
    public void delete(String modelId) {
        dataStore.remove(modelId);
    }

    @Override
    public void updateUser(User model) {
        // Comprueba si el libro digital existe en el almacén de datos
        User existingModel = dataStore.get(model.id);

        if (existingModel != null) {
            // Si el libro existe, actualiza el libro en el almacén de datos
            dataStore.put(model.id, model);
        } else {
            // Si el libro no existe, imprime un mensaje de error
            System.out.println("No se puede actualizar. El libro digital con el ID " + model.id + " no existe.");
        }
    }
}
