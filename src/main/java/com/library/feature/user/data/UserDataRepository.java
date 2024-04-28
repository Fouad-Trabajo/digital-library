package com.library.feature.user.data;

import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.User;
import com.library.feature.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {

    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void createUser(User user) {
        userFileLocalDataSource.save(user);
    }
}
