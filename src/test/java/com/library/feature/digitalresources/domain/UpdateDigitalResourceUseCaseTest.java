package com.library.feature.digitalresources.domain;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;
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
class UpdateDigitalResourceUseCaseTest {


    @Mock
    DigitalResourceRepository digitalResourceRepository;
    UpdateDigitalResourceUseCase updateDigitalResourceUseCase;


    @BeforeEach
    void setUp() {
        updateDigitalResourceUseCase = new UpdateDigitalResourceUseCase(digitalResourceRepository);
    }

    @AfterEach
    void tearDown() {
        updateDigitalResourceUseCase = null;
    }

    @Test
    public void cuandoObtengoUnRecursoMedianteElIdentificadorYSeActualiza(){
        //Given: Declaración de variables
        DigitalResources digitalResources = new DigitalBook("2",
                "Author","500","Crimen","HorseMan","none");

        //When
        updateDigitalResourceUseCase.execute(digitalResources);

        //Then
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).updateDigitalResource(digitalResources);
    }
}