package com.library.feature.user.data.local;

import com.library.feature.user.domain.User;

import java.util.List;

public interface UserLocalDataSource {

    void save(User model);

    void saveList(List<User> models);

    User findById(String id);

    List<User> findAll();

    void delete(String modelId);

    void updateUser(User updatedUser);

}
