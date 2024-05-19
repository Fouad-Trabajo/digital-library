package com.library.feature.digitalresources.domain;


public class CreateDigitalResourceUseCase {

    private DigitalResourceRepository digitalResourceRepository;

    public CreateDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public void execute(DigitalResources digitalResources) {
        digitalResourceRepository.createDigitalResource(digitalResources);
    }
}
