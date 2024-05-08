package com.library.feature.digitalresources.domain.digitalbook;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.digitalresources.domain.digitalbook.DigitalBookRepository;

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
