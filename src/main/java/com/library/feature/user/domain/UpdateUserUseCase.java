package com.library.feature.user.domain;

public class UpdateUserUseCase {

    private UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user){
        userRepository.updateUser(user);
    }
}
