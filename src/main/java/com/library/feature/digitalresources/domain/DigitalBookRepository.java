package com.library.feature.digitalresources.domain;

public interface DigitalBookRepository {

    void createDigitalBook(DigitalBook digitalBook);

    void deleteDigitalBook(String id);

    void updateDigitalBook(DigitalBook digitalBook);
}
