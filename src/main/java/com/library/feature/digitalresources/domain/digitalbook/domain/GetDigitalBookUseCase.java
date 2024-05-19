package com.library.feature.digitalresources.domain.digitalbook.domain;

import com.library.feature.digitalresources.domain.DigitalResourceRepository;

public class GetDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;



    public GetDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public DigitalBook execute(String id){
        return digitalBookRepository.getDigitalBook(id);
    }
}
