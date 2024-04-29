package com.library.feature.digitalresources.domain;

public class UpdateDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public UpdateDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(DigitalBook digitalBook) {
        digitalBookRepository.updateDigitalBook(digitalBook);
    }
}
