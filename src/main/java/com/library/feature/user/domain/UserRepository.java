package com.library.feature.user.domain;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void deleteUser(String id);
    void updateUser(User user);
    List<User> getUsers();
}
