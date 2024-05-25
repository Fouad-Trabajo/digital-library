package com.library.feature.digitalresources.data.musicdata.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.feature.digitalresources.domain.music.domain.Music;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MusicFileLocalDataSource implements MusicLocalDataSource {
    private String nameFile = "music.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Music>>() {
    }.getType();

    @Override
    public void save(Music model) {
        List<Music> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    @Override
    public void saveList(List<Music> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Music> models) {
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
    public Music findById(String id) {
        List<Music> models = findAll();
        for (Music model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public List<Music> findAll() {
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
        List<Music> newList = new ArrayList<>();
        List<Music> models = findAll();
        for (Music model : models) {
            if (!model.id.equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    @Override
    public void updateMusic(Music updateModel) {
        // Obtén todos los libros digitales
        List<Music> models = findAll();

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
