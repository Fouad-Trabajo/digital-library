package com.library.feature.digitalresources.data.local;

import com.library.feature.digitalresources.domain.DigitalBook;

import java.util.List;

public interface DigitalBookLocalDataSource {

    void save(DigitalBook model);

    void saveList(List<DigitalBook> models);

    DigitalBook findById(String id);

    List<DigitalBook> findAll();

    void delete(String modelId);

    void updateDigitalBook(DigitalBook updateBook);
}
