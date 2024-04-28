package com.library.feature.user.domain;

public interface UserRepository {
    void createUser(User user);

    void deleteUser(String id);
}
