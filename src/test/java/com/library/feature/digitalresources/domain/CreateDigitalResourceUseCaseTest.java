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
class CreateDigitalResourceUseCaseTest {

    @Mock
    DigitalResourceRepository digitalResourceRepository;
    CreateDigitalResourceUseCase createDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        createDigitalResourceUseCase = new CreateDigitalResourceUseCase(digitalResourceRepository);
    }

    @AfterEach
    void tearDown() {
        createDigitalResourceUseCase = null;
    }


    @Test
    public void cuandoCreoUnRecursoSeEjecutaElMetodo(){
        //Given: Declaración de variables
        DigitalResources digitalResources  = new DigitalBook("1","Fouad", "120",
                "Terror","MyEditorial","Un castillo abandonado y un maldición");

        //When
        createDigitalResourceUseCase.execute(digitalResources);

        //Then
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).createDigitalResource(digitalResources);

    }
}