package com.library.feature.digitalresources.domain;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetDigitalResourceUseCaseTest {

    @Mock
    DigitalResourceRepository digitalResourceRepository;
    GetDigitalResourceUseCase getDigitalResourceUseCase;


    @BeforeEach
    void setUp() {
        getDigitalResourceUseCase = new GetDigitalResourceUseCase(digitalResourceRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalResourceUseCase = null;
    }

    @Test
    public void cuandoIntroduzcoElIdentificadorYDevuelveElRecursoCorrecto(){
        //Given: Declaración de variables
        DigitalResources digitalResourcesExpected = new DigitalBook("4",
                "Fouad","120","Terror","MyEditorial",
                "Un viaje al interior de la destrozada mente de un niño");


        Mockito.when(digitalResourceRepository.getDigitalResource("4")).thenReturn(digitalResourcesExpected);

        //When
        DigitalResources digitalResourcesReceived =  digitalResourceRepository.getDigitalResource("4");
        DigitalBook digitalBook =  (DigitalBook) digitalResourcesReceived;

        //Then
        Assertions.assertEquals(digitalResourcesReceived.id,"4");
        Assertions.assertEquals(digitalResourcesReceived.author,"Fouad");
        Assertions.assertEquals(digitalBook.numberPages, "120");
        Assertions.assertEquals(digitalBook.genre, "Terror");
        Assertions.assertEquals(digitalBook.editorial, "MyEditorial");
        Assertions.assertEquals(digitalBook.description, "Un viaje al interior " +
                "de la destrozada mente de un niño");



    }

    @Test
    public void cuandoIntroduzcoElIdentificadorIncorrectoDevuelveNull(){
        //Given: Declaración de variables
        String invalidId = "500";
        Mockito.when(digitalResourceRepository.getDigitalResource(invalidId)).thenReturn(null);

        //When
        DigitalResources digitalResourcesReceived = getDigitalResourceUseCase.execute(invalidId);

        //Then
        Assertions.assertNull(digitalResourcesReceived);
    }
}