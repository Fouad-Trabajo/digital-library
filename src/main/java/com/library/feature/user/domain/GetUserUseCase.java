package com.library.feature.user.domain;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;

import java.util.Scanner;

public class GetUserUseCase {

    private UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String id) {
        User user = userRepository.getUser(id);
        System.out.println("\n" + user);
        return user;
    }
}
