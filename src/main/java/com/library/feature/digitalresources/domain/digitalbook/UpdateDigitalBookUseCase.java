package com.library.feature.digitalresources.domain.digitalbook;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.digitalresources.domain.digitalbook.DigitalBookRepository;

public class UpdateDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public UpdateDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(DigitalBook digitalBook) {
        digitalBookRepository.updateDigitalBook(digitalBook);
    }
}
