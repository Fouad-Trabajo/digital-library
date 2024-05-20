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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetDigitalResourcesUseCaseTest {

    @Mock
    DigitalResourceRepository digitalResourceRepository;
    GetDigitalResourcesUseCase getDigitalResourcesUseCase;

    @BeforeEach
    void setUp() {
        getDigitalResourcesUseCase = new GetDigitalResourcesUseCase(digitalResourceRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalResourcesUseCase = null;
    }

    @Test
    public void cuandoSolicitoLaListaDeRecursosEntoncesDevuleveLaListaCorrecta(){
        //Given: Declaración de variables
        List<DigitalResources> digitalResourcesExpected = new ArrayList<>();
        digitalResourcesExpected.add(new DigitalBook("1","Fouad","80",
                "Policias","-","Serie policial"));
        digitalResourcesExpected.add(new DigitalBook("2","Branderson","178",
                "Angles","GB editorial","-"));

        Mockito.when(digitalResourceRepository.getDigitalResources()).thenReturn(digitalResourcesExpected);

        //When
        List<DigitalResources> digitalResourcesReceived = getDigitalResourcesUseCase.execute();

        //Then
        Assertions.assertEquals(digitalResourcesExpected.size(),digitalResourcesReceived.size());

        for (int i = 0; i<digitalResourcesExpected.size();i++){
            DigitalResources expected = digitalResourcesExpected.get(i);
            DigitalResources received = digitalResourcesReceived.get(i);

            DigitalBook digitalBookExpected = (DigitalBook) expected;
            DigitalBook digitalBookReceived = (DigitalBook) received;

            Assertions.assertEquals(digitalBookExpected.id, digitalBookReceived.id);
            Assertions.assertEquals(digitalBookExpected.author, digitalBookReceived.author);
            Assertions.assertEquals(digitalBookExpected.numberPages,digitalBookReceived.numberPages);
            Assertions.assertEquals(digitalBookExpected.genre,digitalBookReceived.genre);
            Assertions.assertEquals(digitalBookExpected.editorial,digitalBookReceived.editorial);
            Assertions.assertEquals(digitalBookExpected.description,digitalBookReceived.description);

        }
    }

    @Test
    public void cuandoSolicitoLaListaDeRecursosYLaListaEstaVacia(){
        //Given: Declaración de variables
        List<DigitalResources> digitalResourcesExpected = new ArrayList<>();
        Mockito.when(digitalResourceRepository.getDigitalResources()).thenReturn(digitalResourcesExpected);

        //When
        List<DigitalResources> digitalResourcesReceivedEmpty = getDigitalResourcesUseCase.execute();


        //Then
        Assertions.assertEquals(0,digitalResourcesReceivedEmpty.size());

    }
}