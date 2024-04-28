package com.library.feature.user.presentation;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.CreateUserUseCase;
import com.library.feature.user.domain.DeleteUserUseCase;
import com.library.feature.user.domain.User;

import java.util.Scanner;

public class UserPresentation {
    static Scanner input = new Scanner(System.in);
    public static void menuUser() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("********** MENÚ **********");
            System.out.println("0. Salir");
            System.out.println("1. Crear usuario");
            System.out.println("2. Borrar usuario");
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
                    System.out.println("Has seleccionado dar de baja a un usuario");
                    UserPresentation.deleteUser();
                    break;
                case 3:

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }


    public static void createUser() {
        System.out.print("Introduce el id del usuario: ");
        String id = input.nextLine();
        System.out.print("Introduce el nombre del usuario: ");
        String name = input.nextLine();
        System.out.print("Introduce el apellido del usuario: ");
        String surname = input.nextLine();
        System.out.print("Introduce el dni del usuario: ");
        String dni = input.nextLine();
        System.out.print("Introduce la fecha de inscripción del usuario: ");
        String dateInscription = input.nextLine();

        User user = new User(id, name, surname, dni, dateInscription);
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        createUserUseCase.execute(user);
        System.out.println(user.toString());
    }

    public static void deleteUser(){
        System.out.print("Introduce el id del usuario que quieres eliminar: ");
        String id=input.nextLine();
        DeleteUserUseCase deleteUserUseCase=new DeleteUserUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        deleteUserUseCase.execute(id);
        System.out.println("El usuario con id " + id + " se ha dado de baja con éxito");

    }
}
