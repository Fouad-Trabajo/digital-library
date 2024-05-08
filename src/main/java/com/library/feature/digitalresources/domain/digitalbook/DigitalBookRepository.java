package com.library.feature.digitalresources.domain.digitalbook;

import java.util.List;

public interface DigitalBookRepository {

    void createDigitalBook(DigitalBook digitalBook);

    void deleteDigitalBook(String id);

    void updateDigitalBook(DigitalBook digitalBook);

    List<DigitalBook> getDigitalBooks();
}
