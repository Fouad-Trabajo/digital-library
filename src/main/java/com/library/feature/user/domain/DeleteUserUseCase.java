package com.library.feature.user.domain;

public class DeleteUserUseCase {

    private UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String id){
        userRepository.deleteUser(id);
    }
}
