package com.library.feature.user.data;

import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.data.local.UserLocalDataSource;
import com.library.feature.user.domain.User;
import com.library.feature.user.domain.UserRepository;


import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {

    private UserLocalDataSource userLocalDataSource;

    public UserDataRepository(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void createUser(User user) {
        userLocalDataSource.save(user);
    }


    @Override
    public void deleteUser(String id) {
        userLocalDataSource.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userLocalDataSource.updateUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userLocalDataSource.findAll();
    }
}
