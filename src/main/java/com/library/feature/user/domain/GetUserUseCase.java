package com.library.feature.user.domain;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;

import java.util.Scanner;

public class GetUserUseCase {

    private UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute() {
        Scanner input = new Scanner(System.in);
        User user;
        do {
            System.out.print("Introduce el id del usuario: ");
            String id = input.nextLine();
            user = userRepository.getUser(id);
            if (user == null) {
                System.out.println("El id " + id + " del usuario no corresponde a ningún usuario");
            } else {
                System.out.println("\n" + user);
            }
        } while (user == null);
        return user;
    }
}
