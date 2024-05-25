package com.library.feature.user.presentation;

import com.library.feature.user.domain.*;


import java.util.List;
import java.util.Scanner;

public class UserPresentation {
    static Scanner input = new Scanner(System.in);

    static UserFactory userFactory = new UserFactory();

    public UserPresentation(UserFactory userFactory) {
    }

    static UserPresentation userPresentation = new UserPresentation(userFactory);


    public static void menuUser() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*********** MENÚ USUARIO ***********");
            System.out.println("0. Volver atrás                    *");
            System.out.println("1. Crear usuario                   *");
            System.out.println("2. Borrar usuario                  *");
            System.out.println("3. Actualizar usuario              *");
            System.out.println("4. Obtener listado de usuarios     *");
            System.out.println("5. Obtener 1 usuario mediante id   *");
            System.out.println("************************************");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atrás...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un usuario.");
                    userPresentation.createUser();
                    break;
                case 2:
                    System.out.println("Has seleccionado dar de baja a un usuario");
                    userPresentation.deleteUser();
                    break;
                case 3:
                    System.out.println("Has seleccionado modificar datos de un usuario");
                    userPresentation.updateUser();
                    break;
                case 4:
                    System.out.println("Has seleccionado obtener un listado de usuarios\n");
                    userPresentation.getUsers();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar 1 usuario");
                    userPresentation.getUser();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }


    public void createUser() {
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
        CreateUserUseCase createUserUseCase = userFactory.buildCreateUser();
        createUserUseCase.execute(user);
    }

    public void deleteUser() {
        System.out.print("Introduce el id del usuario que quieres eliminar: ");
        String id = input.nextLine();
        DeleteUserUseCase deleteUserUseCase = userFactory.buildDeleteUser();
        deleteUserUseCase.execute(id);
        System.out.println("El usuario con id " + id + " se ha dado de baja con éxito");
    }

    public void updateUser() {
        User user = getUser();
        UpdateUserUseCase updateUserUseCase = userFactory.buildUpdateUser();
        System.out.println("Modifica los datos que quieras");
        System.out.print("Introduce el nombre del usuario: ");
        String name = input.nextLine();
        System.out.print("Introduce el apellido del usuario: ");
        String surname = input.nextLine();
        System.out.print("Introduce el dni del usuario: ");
        String dni = input.nextLine();
        System.out.print("Introduce la fecha de inscripción del usuario: ");
        String dateInscription = input.nextLine();

        User updateUser = new User(user.id, name, surname, dni, dateInscription);
        updateUserUseCase.execute(updateUser);
    }

    public void getUsers() {
        GetUsersUseCase getUsersUseCase = userFactory.buildGetUsers();
        List<User> usersList = getUsersUseCase.execute();
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    public User getUser() {
        Scanner input = new Scanner(System.in);
        GetUserUseCase getUserUseCase = userFactory.buildGetUser();

        User user;
        do {
            System.out.print("Introduce el id del usuario: ");
            String id = input.nextLine();
            user = getUserUseCase.execute(id);
            if (user == null) {
                System.out.println("El id " + id + " que estás buscando no corresponde" +
                        "a ningún usuario dado de alta en el sistema");
            } else {
                System.out.println("\n" + user);
            }
        } while (user == null);
        return user;
    }
}
