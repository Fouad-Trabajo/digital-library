package com.library.feature.user.presentation;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.CreateUserUseCase;
import com.library.feature.user.domain.DeleteUserUseCase;
import com.library.feature.user.domain.User;

import java.util.Scanner;

public class UserPresentation {
    static Scanner input = new Scanner(System.in);

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
