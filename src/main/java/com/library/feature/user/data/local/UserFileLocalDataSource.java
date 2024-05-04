package com.library.feature.user.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.feature.demo.domain.Demo;
import com.library.feature.user.domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserFileLocalDataSource implements UserLocalDataSource {
    private String nameFile = "user.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<User>>() {
    }.getType();

    @Override
    public void save(User model) {
        List<User> models = findAll();
        for (User existingUser : models) {
            if (existingUser.id.equals(model.id)) {
                System.err.println("Error, ya existe un usuario con el ID " + model.id);
                return;
            }
        }
        models.add(model);
        saveToFile(models);
    }

    @Override
    public void saveList(List<User> models) {
        saveToFile(models);
    }

    private void saveToFile(List<User> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos actualizados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    @Override
    public User findById(String id) {
        List<User> models = findAll();
        for (User model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    @Override
    public void delete(String modelId) {
        List<User> newList = new ArrayList<>();
        List<User> models = findAll();
        for (User model : models) {
            if (!model.id.equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    @Override
    public void updateUser(User updatedUser) {
        // Obtén todos los usuarios
        List<User> users = findAll();

        // Busca el usuario que deseas actualizar y reemplázalo
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id.equals(updatedUser.id)) {
                users.set(i, updatedUser);
                break;
            }
        }

        // Guarda la lista actualizada de usuarios en el fichero
        saveList(users);
    }

}
