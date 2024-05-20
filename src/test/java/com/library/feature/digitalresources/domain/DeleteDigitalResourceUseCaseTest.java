package com.library.feature.digitalresources.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeleteDigitalResourceUseCaseTest {

    @Mock
    DigitalResourceRepository digitalResourceRepository;
    DeleteDigitalResourceUseCase deleteDigitalResourceUseCase;


    @BeforeEach
    void setUp() {
        deleteDigitalResourceUseCase = new DeleteDigitalResourceUseCase(digitalResourceRepository);
    }

    @AfterEach
    void tearDown() {
        deleteDigitalResourceUseCase = null;
    }


    @Test
    public void cuandoEscriboElIdYSeBorraElRecurso(){
        //Given: Declaración de variables
        String idDelete = "1";

        //When
        deleteDigitalResourceUseCase.execute(idDelete);


        //Then
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).deleteDigitalResource(idDelete);
    }
}