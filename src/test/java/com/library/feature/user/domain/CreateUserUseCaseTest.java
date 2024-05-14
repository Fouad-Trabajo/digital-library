package com.library.feature.user.domain;

import com.library.feature.user.data.UserDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    private CreateUserUseCase createUserUseCase;
    @Mock
    private UserDataRepository userDataRepository;


    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(userDataRepository);
    }

    @AfterEach
    void tearDown() {
        createUserUseCase = null;
    }

    @Test
    public void cuandoCreoUnUsuarioCorrectamenteYObtengoElModeloCorrecto(){
        //Given
        User user = new User("1","Gabriel","Polo","12360138M","10/05/2014");


        //When
        createUserUseCase.execute(user);

        //Then
        Mockito.verify(userDataRepository,Mockito.times(1)).createUser(user);


    }
}