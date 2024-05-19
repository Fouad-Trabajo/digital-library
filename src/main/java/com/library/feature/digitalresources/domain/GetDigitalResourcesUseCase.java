package com.library.feature.digitalresources.domain;

import java.util.List;

public class GetDigitalResourcesUseCase {

    private DigitalResourceRepository digitalResourceRepository;

    public GetDigitalResourcesUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public List<DigitalResources> execute() {
        return digitalResourceRepository.getDigitalResources();
    }
}
