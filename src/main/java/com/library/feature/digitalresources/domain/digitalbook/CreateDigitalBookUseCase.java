package com.library.feature.digitalresources.domain.digitalbook;


public class CreateDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public CreateDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(DigitalBook digitalBook) {
        digitalBookRepository.createDigitalBook(digitalBook);
    }
}
