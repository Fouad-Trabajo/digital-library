package com.library.feature.digitalresources.data.local;

import com.library.feature.digitalresources.domain.DigitalResources;


import java.util.List;

public interface DigitalResourceLocalDataSource {

    void save(DigitalResources model);

    void saveList(List<DigitalResources> models);

    DigitalResources findById(String id);

    List<DigitalResources> findAll();

    void delete(String modelId);

    void updateDigitalBook(DigitalResources updateBook);
}
