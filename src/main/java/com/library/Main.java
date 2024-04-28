package com.library;

import com.library.feature.user.domain.User;
import com.library.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenid@ a nuestra biblioteca digital");
        System.out.println("¿Qué desea hacer?");
        do {
            System.out.println("********** MENÚ PRINCIPAL**********");
            System.out.println("0. Salir");
            System.out.println("1. Menú usuario");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Has seleccionado salir. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("Has seleccionado el menú del usuario.");
                    UserPresentation.menuUser();
                    break;
                case 2:
                    System.out.println("Has seleccionado el menú de...");
                    break;
                case 3:

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}