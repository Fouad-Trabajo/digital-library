package com.library.feature.user.presentation;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.*;


import java.util.List;
import java.util.Scanner;

public class UserPresentation {
    static Scanner input = new Scanner(System.in);

    public static void menuUser() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("********** MENÚ USUARIO **********");
            System.out.println("0. Volver atrás");
            System.out.println("1. Crear usuario");
            System.out.println("2. Borrar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Obtener listado de usuarios");
            System.out.println("5. Obtener 1 usuario mediante id");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atrás...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un usuario.");
                    createUser();
                    break;
                case 2:
                    System.out.println("Has seleccionado dar de baja a un usuario");
                    deleteUser();
                    break;
                case 3:
                    System.out.println("Has seleccionado modificar datos de un usuario");
                    updateUser();
                    break;
                case 4:
                    System.out.println("Has seleccionado obtener un listado de usuarios\n");
                    getUsers();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar 1 usuario");
                    getUser();
                    break;
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
    }

    public static void deleteUser() {
        System.out.print("Introduce el id del usuario que quieres eliminar: ");
        String id = input.nextLine();
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        deleteUserUseCase.execute(id);
        System.out.println("El usuario con id " + id + " se ha dado de baja con éxito");
    }

    public static void updateUser() {
        System.out.print("Introduce el id del usuario que quieres modificar: ");
        String id = input.nextLine();
        UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        System.out.println("Modifica los datos que quieras");
        System.out.print("Introduce el nombre del usuario: ");
        String name = input.nextLine();
        System.out.print("Introduce el apellido del usuario: ");
        String surname = input.nextLine();
        System.out.print("Introduce el dni del usuario: ");
        String dni = input.nextLine();
        System.out.print("Introduce la fecha de inscripción del usuario: ");
        String dateInscription = input.nextLine();
        User user = new User(id, name, surname, dni, dateInscription);
        updateUserUseCase.execute(user);
    }

    public static void getUsers() {
        GetUsersUseCase getUsersUseCase = new GetUsersUseCase(new UserDataRepository(
                new UserFileLocalDataSource()));
        List<User> usersList = getUsersUseCase.execute();
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    public static void getUser() {
        System.out.print("Introduce el id del usuario que quieres mostrar: ");
        String id = input.next();
        GetUserUseCase getUserUseCase = new GetUserUseCase(
                new UserDataRepository(new UserFileLocalDataSource()));
        User user = getUserUseCase.execute(id);
        System.out.println("\n" + user);
    }
}
