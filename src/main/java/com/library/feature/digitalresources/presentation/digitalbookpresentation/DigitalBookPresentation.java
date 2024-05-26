package com.library.feature.digitalresources.presentation.digitalbookpresentation;

import com.library.feature.digitalresources.domain.*;
import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;
import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBookFactory;


import java.util.List;
import java.util.Scanner;

public class DigitalBookPresentation {
    static Scanner input = new Scanner(System.in);
    static DigitalBookFactory digitalBookFactory = new DigitalBookFactory();

    public DigitalBookPresentation(DigitalBookFactory digitalBookFactory) {
    }

    static DigitalBookPresentation digitalBookPresentation = new DigitalBookPresentation(digitalBookFactory);

    public static void menuDigitalBook() {
        int opcion;

        do {
            System.out.println("********** MENÚ LIBROS DIGITALES **********");
            System.out.println("0. Volver atrás                           *");
            System.out.println("1. Crear libro digital                    *");
            System.out.println("2. Borrar libro digital                   *");
            System.out.println("3. Actualizar datos del libro             *");
            System.out.println("4. Obtener listado de libros              *");
            System.out.println("5. Obtener 1 libro mediante id            *");
            System.out.println("*******************************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un libro digital.");
                    digitalBookPresentation.createDigitalBook();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un libro digital.");
                    digitalBookPresentation.deleteDigitalBook();
                    break;
                case 3:
                    System.out.println("Has seleccionado actualizar los datos/atributos de un libro digital.");
                    digitalBookPresentation.updateDigitalBook();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar el listado de libros que hay en el sistema.\n");
                    digitalBookPresentation.getDigitalBooks();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar 1 libro");
                    digitalBookPresentation.getDigitalBook();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public void createDigitalBook() {
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
        CreateDigitalResourceUseCase createDigitalResourceUseCase = digitalBookFactory.buildCreateResource();
        createDigitalResourceUseCase.execute(digitalBook);
    }

    public void deleteDigitalBook() {
        input.nextLine();
        System.out.print("Introduce el id del libro que quieres dar de baja: ");
        String id = input.nextLine();
        DeleteDigitalResourceUseCase deleteDigitalResourceUseCase = digitalBookFactory.buildDeleteResource();
        deleteDigitalResourceUseCase.execute(id);
        System.out.println("El lbro con id " + id + " ha sido borrado exitosamente");
    }

    public void updateDigitalBook() {
        DigitalBook digitalBook = getDigitalBook();
        UpdateDigitalResourceUseCase updateDigitalResourceUseCase = digitalBookFactory.buildUpdateResource();
        input.nextLine();
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
        DigitalResources digitalBookUpdate = new DigitalBook(digitalBook.id, author, numberPages, genre,
                editorial, description);
        updateDigitalResourceUseCase.execute(digitalBookUpdate);
    }

    public void getDigitalBooks() {
        GetDigitalResourcesUseCase getDigitalResourcesUseCase = digitalBookFactory.buildGetResourcres();
        List<DigitalResources> digitalBooksList = getDigitalResourcesUseCase.execute();
        for (DigitalResources digitalBook : digitalBooksList) {
            System.out.println(digitalBook);
        }
    }

    public DigitalBook getDigitalBook() {
        GetDigitalResourceUseCase getDigitalResourceUseCase = digitalBookFactory.buildGetResource();
        DigitalBook digitalBook;
        do {
            System.out.print("Introduce el id del libro digital: ");
            String id = input.next();
            digitalBook = (DigitalBook) getDigitalResourceUseCase.execute(id);
            if (digitalBook == null) {
                System.out.println("El id " + id + " que has introducido no corresponde a ningún libro");
            } else {
                System.out.println("\n" + digitalBook);
            }
        } while (digitalBook == null);
        return digitalBook;
    }
}