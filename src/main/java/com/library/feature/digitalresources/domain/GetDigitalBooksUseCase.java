package com.library.feature.digitalresources.domain;

import java.util.ArrayList;
import java.util.List;

public class GetDigitalBooksUseCase {

    private DigitalBookRepository digitalBookRepository;

    public GetDigitalBooksUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public List<DigitalBook> execute() {
        return digitalBookRepository.getDigitalBooks();
    }
}
