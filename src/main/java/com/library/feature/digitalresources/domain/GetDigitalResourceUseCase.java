package com.library.feature.digitalresources.domain;

public class GetDigitalResourceUseCase {

    private DigitalResourceRepository digitalResourceRepository;

    public GetDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public DigitalResources execute(String id) {
        return digitalResourceRepository.getDigitalResource(id);
    }
}
