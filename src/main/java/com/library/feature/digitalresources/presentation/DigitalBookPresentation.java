package com.library.feature.digitalresources.presentation;

import com.library.feature.digitalresources.data.DigitalBookDataRepository;
import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.CreateDigitalBookUseCase;
import com.library.feature.digitalresources.domain.DigitalBook;

import java.util.Scanner;

public class DigitalBookPresentation {
    static Scanner input = new Scanner(System.in);
    public static void menuDigitalBook() {


        int opcion;

        do {
            System.out.println("********** MENÚ **********");
            System.out.println("0. Salir");
            System.out.println("1. Crear libro digital");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Has seleccionado salir. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un libro digital.");
                    createDigitalBook();
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
        DigitalBook digitalBook = new DigitalBook(id,author, numberPages, genre,
                editorial, description);
        CreateDigitalBookUseCase createDigitalBookUseCase = new CreateDigitalBookUseCase(
                new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        createDigitalBookUseCase.execute(digitalBook);
    }
}
