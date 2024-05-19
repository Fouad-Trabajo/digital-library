package com.library.feature.digitalresources.domain.music.presentation;

import java.util.Scanner;

public class MusicPresentation {
    static Scanner input = new Scanner (System.in);
    public static void menuMusic() {
        int opcion;

        do {
            System.out.println("********** MENÚ MÚSICA **********");
            System.out.println("0. Volver atrás                 *");
            System.out.println("1. Crear canción                *");
            System.out.println("*********************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un canción.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }
}
