package com.library.feature.digitalresources.domain;



public class UpdateDigitalResourceUseCase {

    private DigitalResourceRepository digitalResourceRepository;

    public UpdateDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public void execute(DigitalResources digitalResources) {
        digitalResourceRepository.updateDigitalResource(digitalResources);
    }
}
