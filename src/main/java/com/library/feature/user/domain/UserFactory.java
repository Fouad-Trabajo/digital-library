package com.library.feature.user.domain;

import com.library.feature.user.data.UserDataRepository;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.data.local.UserLocalDataSource;
import com.library.feature.user.domain.*;

public class UserFactory {

    private final UserLocalDataSource userLocalDataSource = new UserFileLocalDataSource();
    private final UserRepository userRepository = new UserDataRepository(userLocalDataSource);


    public CreateUserUseCase buildCreateUser() {
        return new CreateUserUseCase(userRepository);
    }

    public DeleteUserUseCase buildDeleteUser() {
        return new DeleteUserUseCase(userRepository);
    }

    public UpdateUserUseCase buildUpdateUser() {
        return new UpdateUserUseCase(userRepository);
    }


    public GetUsersUseCase buildGetUsers() {
        return new GetUsersUseCase(userRepository);
    }

    public GetUserUseCase buildGetUser() {
        return new GetUserUseCase(userRepository);
    }


}
