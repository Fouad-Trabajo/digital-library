package com.library.feature.digitalresources.presentation;


import com.library.feature.digitalresources.data.DigitalResourceDataRepository;
import com.library.feature.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.library.feature.digitalresources.domain.CreateDigitalResourceUseCase;
import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.domain.GetDigitalResourceUseCase;
import com.library.feature.digitalresources.domain.digitalbook.presentation.DigitalBookPresentation;
import com.library.feature.digitalresources.domain.music.presentation.MusicPresentation;

import java.util.Scanner;

public class DigitalResourcesPresentation {
    static Scanner input = new Scanner(System.in);
    public static void menuDigitalResources() {


        System.out.println("¿Qué desea hacer?");
        int opcion;
        do {
            System.out.println("********** MENÚ RECURSOS DIGITALES **********");
            System.out.println("0. Volver atrás                             *");
            System.out.println("1. Libros digitales                         *");
            System.out.println("2. Música                                   *");
            System.out.println("3. Próximamente...                          *");
            System.out.println("*********************************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado el menú de libros digitales.");
                    DigitalBookPresentation.menuDigitalBook();
                    break;
                case 2:
                    System.out.println("Has seleccionado el menú de la música.");
                    MusicPresentation.menuMusic();
                    break;
                case 3:
                    System.out.println("Has seleccionado el menú de libros digitales.");
                    getDigitalResource();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);


    }

    public static void createDigitalResource() {
        Scanner input = new Scanner(System.in);
        input.nextLine(); //Consumir línea pendiente
        System.out.print("Introduce el id del libro: ");
        String id = input.nextLine();
        System.out.print("Nombre del autor del libro: ");
        String author = input.nextLine();

        DigitalResources digitalResources = new DigitalResources(id, author);
        CreateDigitalResourceUseCase createDigitalResourceUseCase = new CreateDigitalResourceUseCase(
                new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));
        createDigitalResourceUseCase.execute(digitalResources);

    }

    public static DigitalResources getDigitalResource() {
        GetDigitalResourceUseCase getDigitalBookUseCase = new GetDigitalResourceUseCase(
                new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));

        DigitalResources digitalResources;
        do {
            input.next();
            System.out.print("Introduce el id del libro digital: ");
            String id = input.nextLine();
            digitalResources = getDigitalBookUseCase.execute(id);
            if (digitalResources == null) {
                System.out.println("El id " + id + " que has introducido no corresponde a ningún libro");
            } else{
                System.out.println("\n" + digitalResources);
            }
        } while (digitalResources == null);
        return  digitalResources;
    }
}
