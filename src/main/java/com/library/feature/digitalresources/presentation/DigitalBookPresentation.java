package com.library.feature.digitalresources.presentation;

import com.library.feature.digitalresources.data.DigitalBookDataRepository;
import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.digitalbook.*;


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
        System.out.print("Introduce el id del libro: ");
        String id = input.next();
        System.out.print("Nombre del autor del libro: ");
        String author = input.next();
        System.out.print("Nº páginas del libro : ");
        String numberPages = input.next();
        System.out.print("Género del libro: ");
        String genre = input.next();
        System.out.print("Editorial del libro: ");
        String editorial = input.next();
        System.out.print("Descripción del libro: ");
        String description = input.next();
        DigitalBook digitalBook = new DigitalBook(id, author, numberPages, genre,
                editorial, description);
        CreateDigitalBookUseCase createDigitalBookUseCase = new CreateDigitalBookUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        createDigitalBookUseCase.execute(digitalBook);
    }

    public static void deleteDigitalBook() {
        System.out.print("Introduce el id del libro que quieres dar de baja: ");
        String id = input.next();
        DeleteDigitalBookUseCase deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        deleteDigitalBookUseCase.execute(id);
        System.out.println("El lbro con id " + id + " ha sido borrado exitosamente");
    }

    public static void updateDigitalBook() {
        System.out.print("Introduce el id del libro que quieres actualizar: ");
        String id = input.next();
        UpdateDigitalBookUseCase updateDigitalBookUseCase = new UpdateDigitalBookUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        System.out.println("Cambia los datos que quieras");
        System.out.print("Nombre del autor del libro: ");
        String author = input.next();
        System.out.print("Nº páginas del libro : ");
        String numberPages = input.next();
        System.out.print("Género del libro: ");
        String genre = input.next();
        System.out.print("Editorial del libro: ");
        String editorial = input.next();
        System.out.print("Descripción del libro: ");
        String description = input.next();
        DigitalBook digitalBook = new DigitalBook(id, author, numberPages, genre,
                editorial, description);
        updateDigitalBookUseCase.execute(digitalBook);
    }

    public static void getDigitalBooks() {
        GetDigitalBooksUseCase getDigitalBooksUseCase = new GetDigitalBooksUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        List<DigitalBook> digitalBooksList = getDigitalBooksUseCase.execute();
        for (DigitalBook digitalBook : digitalBooksList)
            System.out.println(digitalBook);
    }

    public static void getDigitalBook() {
        System.out.print("Introduce el id del libro que quieres ver: ");
        String id = input.next();
        GetDigitalBookUseCase getDigitalBookUseCase = new GetDigitalBookUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        DigitalBook digitalBook = getDigitalBookUseCase.execute(id);
        System.out.println("\n" + digitalBook);
    }
}
