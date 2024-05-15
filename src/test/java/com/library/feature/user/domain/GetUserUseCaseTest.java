package com.library.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetUserUseCaseTest {

    GetUserUseCase getUserUseCase;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        getUserUseCase = new GetUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        getUserUseCase = null;
    }

    @Test
    public void cuandoIntroduzcoUnIdValidoObtengoElModeloCorrecto() {
        //Given: Declaración de variables
        User userExpected = new User("1", "Federico", "García", "45610349E", "18/06/2021");
        Mockito.when(userRepository.getUser("1")).thenReturn(userExpected);
        //String id = userExpected.id;

        //When
        User userRecived = getUserUseCase.execute("1");

        //Then
        Assertions.assertEquals(userRecived.id, "1");
        Assertions.assertEquals(userRecived.name, "Federico");
        Assertions.assertEquals(userRecived.surname, "García");
        Assertions.assertEquals(userRecived.dni, "45610349E");
        Assertions.assertEquals(userRecived.dateInscription, "18/06/2021");

    }


    @Test
    public void cuandoIntroduzcoUn_id_invalidoObtengoNull() {
        //Given: Declaración de variables
        String invalidId = "2";
        Mockito.when(userRepository.getUser("2")).thenReturn(null);


        //When
        User userReceived = getUserUseCase.execute(invalidId);

        //Then
        Assertions.assertNull(userReceived);

    }


}