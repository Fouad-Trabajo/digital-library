package com.library.feature.digitalresources.presentation;


import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBookFactory;
import com.library.feature.digitalresources.domain.music.domain.MusicFactory;
import com.library.feature.digitalresources.presentation.digitalbookpresentation.DigitalBookPresentation;
import com.library.feature.digitalresources.presentation.musicpresentation.MusicPresentation;

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
                    System.out.println("Próximamente...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);


    }

    public static DigitalResources selectResource() {
        System.out.println("Recursos disponibles: ");
        System.out.println("1. Libro Digital");
        System.out.println("2. Música");
        System.out.print("Selecciona el tipo de recurso digital que quieres solicitar: ");
        int option = input.nextInt();

        DigitalBookFactory digitalBookFactory = new DigitalBookFactory();
        MusicFactory musicFactory = new MusicFactory();
        DigitalBookPresentation digitalBookPresentation = new DigitalBookPresentation(digitalBookFactory);
        MusicPresentation musicPresentation = new MusicPresentation(musicFactory);

        return switch (option) {
            case 1 -> digitalBookPresentation.getDigitalBook();
            case 2 -> musicPresentation.getMusic();
            default -> null;
        };
    }
}
