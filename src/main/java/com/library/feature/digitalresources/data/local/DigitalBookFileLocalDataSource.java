package com.library.feature.digitalresources.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DigitalBookFileLocalDataSource implements DigitalBookLocalDataSource{
    private String nameFile = "digitalBook.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<DigitalBook>>() {
    }.getType();

    @Override
    public void save(DigitalBook model) {
        List<DigitalBook> models = findAll();
        for (DigitalBook existingBook : models) {
            if (model.id.equals(existingBook.id)) {
                System.err.println("Error, ya existe un libro digital con el ID " + model.id);
                return;
            }
        }
        models.add(model);
        saveToFile(models);
    }

    @Override
    public void saveList(List<DigitalBook> models) {
        saveToFile(models);
    }

    private void saveToFile(List<DigitalBook> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    @Override
    public DigitalBook findById(String id) {
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public List<DigitalBook> findAll() {
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
        List<DigitalBook> newList = new ArrayList<>();
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (!model.id.equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    @Override
    public void updateDigitalBook(DigitalBook updateModel) {
        // Obtén todos los libros digitales
        List<DigitalBook> models = findAll();

        // Busca el libro que deseas actualizar y reemplázalo
        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).id.equals(updateModel.id)) {
                models.set(i, updateModel);
                break;
            }
        }

        // Guarda la lista actualizada de libros en el fichero
        saveList(models);
    }
}
