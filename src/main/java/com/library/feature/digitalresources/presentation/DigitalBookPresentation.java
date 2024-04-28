package com.library.feature.digitalresources.presentation;

import com.library.feature.digitalresources.data.DigitalBookDataRepository;
import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.CreateDigitalBookUseCase;
import com.library.feature.digitalresources.domain.DeleteDigitalBookUseCase;
import com.library.feature.digitalresources.domain.DigitalBook;

import java.util.Scanner;

public class DigitalBookPresentation {
    static Scanner input = new Scanner(System.in);

    public static void menuDigitalBook() {


        int opcion;

        do {
            System.out.println("********** MENÚ **********");
            System.out.println("0. Volver atrás");
            System.out.println("1. Crear libro digital");
            System.out.println("2. Borrar libro digital");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras..");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un libro digital.");
                    createDigitalBook();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un libro digital.");
                    deleteDigitalBook();
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
}
