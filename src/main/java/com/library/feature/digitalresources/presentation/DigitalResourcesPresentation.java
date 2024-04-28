package com.library.feature.digitalresources.presentation;


import java.util.Scanner;

public class DigitalResourcesPresentation {
    public static void menuDigitalResources() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué desea hacer?");
        int opcion;
        do {
            System.out.println("********** MENÚ RECURSOS DIGITALES **********");
            System.out.println("0. Volver atrás");
            System.out.println("1. Libros digitales");
            System.out.println("2. Próximos recursos...");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado el menú del usuario.");
                    DigitalBookPresentation.menuDigitalBook();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
