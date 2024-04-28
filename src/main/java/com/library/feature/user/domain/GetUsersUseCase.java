package com.library.feature.user.domain;

import java.util.ArrayList;
import java.util.List;

public class GetUsersUseCase {

    private UserRepository userRepository;

    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.getUsers();
    }
}
