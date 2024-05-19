package com.library.feature.digitalresources.domain;



public class DeleteDigitalResourceUseCase {

   private DigitalResourceRepository digitalResourceRepository;

    public DeleteDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public void execute (String id){
        digitalResourceRepository.deleteDigitalResource(id);
    }
}
