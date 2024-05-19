package com.library.feature.digitalresources.domain.digitalbook.data.local;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;

import java.util.List;

public interface DigitalBookLocalDataSource {

    void save(DigitalBook model);

    void saveList(List<DigitalBook> models);

    DigitalBook findById(String id);

    List<DigitalBook> findAll();

    void delete(String modelId);

    void updateDigitalBook(DigitalBook updateBook);
}
