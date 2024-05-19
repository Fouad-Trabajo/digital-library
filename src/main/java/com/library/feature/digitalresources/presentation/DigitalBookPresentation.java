package com.library.feature.digitalresources.presentation;

import com.library.feature.digitalresources.data.DigitalResourceDataRepository;
import com.library.feature.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.library.feature.digitalresources.domain.*;
import com.library.feature.digitalresources.domain.digitalbook.data.DigitalBookDataRepository;
import com.library.feature.digitalresources.domain.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;


import java.util.List;
import java.util.Scanner;

public class DigitalBookPresentation {
    static Scanner input = new Scanner(System.in);

    public static void menuDigitalBook() {
        int opcion;

        do {
            System.out.println("********** MENÚ LIBROS DIGITALES **********");
            System.out.println("0. Volver atrás");
            System.out.println("1. Crear libro digital");
            System.out.println("2. Borrar libro digital");
            System.out.println("3. Actualizar datos del libro");
            System.out.println("4. Obtener listado de libros");
            System.out.println("5. Obtener 1 libro mediante id");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un libro digital.");
                    createDigitalBook();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un libro digital.");
                    deleteDigitalBook();
                    break;
                case 3:
                    System.out.println("Has seleccionado actualizar los datos/atributos de un libro digital.");
                    updateDigitalBook();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar el listado de libros que hay en el sistema.\n");
                    getDigitalBooks();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar 1 libro");
                    getDigitalBook();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void createDigitalBook() {
        input.nextLine(); //Consumir línea pendiente
        System.out.print("Introduce el id del libro: ");
        String id = input.nextLine();
        System.out.print("Nombre del autor del libro: ");
        String author = input.nextLine();
        System.out.print("Nº páginas del libro : ");
        String numberPages = input.nextLine();
        System.out.print("Género del libro: ");
        String genre = input.nextLine();
        System.out.print("Editorial del libro: ");
        String editorial = input.nextLine();
        System.out.print("Descripción del libro: ");
        String description = input.nextLine();
        DigitalResources digitalBook = new DigitalBook(id, author, numberPages, genre,
                editorial, description);
        CreateDigitalResourceUseCase createDigitalResourcesUseCase = new CreateDigitalResourceUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        createDigitalResourcesUseCase.execute(digitalBook);
    }

    public static void deleteDigitalBook() {
        input.nextLine();
        System.out.print("Introduce el id del libro que quieres dar de baja: ");
        String id = input.nextLine();
        DeleteDigitalResourceUseCase deleteDigitalResourceUseCase = new DeleteDigitalResourceUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        deleteDigitalResourceUseCase.execute(id);
        System.out.println("El lbro con id " + id + " ha sido borrado exitosamente");
    }

    public static void updateDigitalBook() {
        DigitalBook digitalBook = getDigitalBook();
        UpdateDigitalResourceUseCase updateDigitalResourceUseCase = new UpdateDigitalResourceUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        input.nextLine(); //Consumir línea pendiente
        System.out.println("Cambia los datos que quieras");
        System.out.print("Nombre del autor del libro: ");
        String author = input.nextLine();
        System.out.print("Nº páginas del libro : ");
        String numberPages = input.nextLine();
        System.out.print("Género del libro: ");
        String genre = input.nextLine();
        System.out.print("Editorial del libro: ");
        String editorial = input.nextLine();
        System.out.print("Descripción del libro: ");
        String description = input.nextLine();
        DigitalBook digitalBookUpdate = new DigitalBook(digitalBook.id, author, numberPages, genre,
                editorial, description);
        updateDigitalResourceUseCase.execute(digitalBookUpdate);
    }

    public static void getDigitalBooks() {
        GetDigitalResourcesUseCase getDigitalResourcesUseCase = new GetDigitalResourcesUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        List<DigitalResources> digitalBooksList = getDigitalResourcesUseCase.execute();
        for (DigitalResources digitalBook : digitalBooksList) {
            System.out.println(digitalBook);
        }
    }

    public static DigitalBook getDigitalBook() {
        GetDigitalResourceUseCase getDigitalResourceUseCase = new GetDigitalResourceUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));

        DigitalResources digitalBook;
        do {
            System.out.print("Introduce el id del libro digital: ");
            String id = input.nextLine();
            digitalBook = getDigitalResourceUseCase.execute(id);
            if (digitalBook == null) {
                System.out.println("El id " + id + " que has introducido no corresponde a ningún libro");
            } else if (digitalBook instanceof DigitalBook) {
                System.out.println("\n" + digitalBook);
                return (DigitalBook) digitalBook;
            }


        } while (digitalBook == null);

        return null;

    }


}
