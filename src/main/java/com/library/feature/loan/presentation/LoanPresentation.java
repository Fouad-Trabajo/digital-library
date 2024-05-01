package com.library.feature.loan.presentation;

import java.util.Scanner;

public class LoanPresentation {

    public static void menuLoan(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("********** MENÚ PRÉSTAMOS **********");
            System.out.println("0. Salir");
            System.out.println("1. Selecciona opción 1");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Has seleccionado salir. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("Has seleccionado la opción 1 por defecto.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

}
