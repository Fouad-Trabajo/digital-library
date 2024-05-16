package com.library.feature.digitalresources.domain.digitalbook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    CreateDigitalBookUseCase createDigitalBookUseCase;

    @BeforeEach
    void setUp() {
        createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        createDigitalBookUseCase = null;
    }



    @Test
    public void obtengoUnRecursoDeFormaCorrectaMedianteElIdentificador(){
        //Given: Declaración de variables
        DigitalBook digitalBook = new DigitalBook("1","Tolkien","1700",
                "Fantasía","HorseMan","Fundir un anillo a un volcán");

        //When
        createDigitalBookUseCase.execute(digitalBook);

        //Then
        Mockito.verify(digitalBookRepository, Mockito.times(1)).createDigitalBook(digitalBook);

    }
}