package com.library.feature.user.data;

import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.User;
import com.library.feature.user.domain.UserRepository;


import java.util.ArrayList;
import java.util.List;

public class UserDataRepository implements UserRepository {

    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void createUser(User user) {
        userFileLocalDataSource.save(user);
    }


    @Override
    public void deleteUser(String id) {
        userFileLocalDataSource.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userFileLocalDataSource.updateUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userFileLocalDataSource.findAll();
    }
}
