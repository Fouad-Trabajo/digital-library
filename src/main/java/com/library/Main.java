package com.library;

import com.library.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("********** MENÚ **********");
            System.out.println("0. Salir");
            System.out.println("1. Crear usuario");
            //System.out.println("2. Borrar usuario");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Has seleccionado salir. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un usuario.");
                    UserPresentation.createUser();
                    break;
                case 2:
                    //System.out.println("Has seleccionado....");
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