package com.library.feature.digitalresources.domain.digitalbook;

public class DeleteDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public DeleteDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(String id) {
        digitalBookRepository.deleteDigitalBook(id);
    }
}
