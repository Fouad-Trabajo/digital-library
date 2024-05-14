package com.library.feature.loan.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.feature.loan.domain.Loan;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



public class LoanFileLocalDataSource implements LoanLocalDataSource {
    private String nameFile = "loan.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Loan>>() {
    }.getType();

    @Override
    public void save(Loan model) {
        List<Loan> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    @Override
    public void saveList(List<Loan> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Loan> models) {
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
    public Loan findById(String id) {
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public List<Loan> findAll() {
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
        List<Loan> newList = new ArrayList<>();
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (!model.id.equals(modelId)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }
}
