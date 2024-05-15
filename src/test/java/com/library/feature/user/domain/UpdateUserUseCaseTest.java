package com.library.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    UpdateUserUseCase updateUserUseCase;


    @BeforeEach
    void setUp() {
        updateUserUseCase = new UpdateUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        updateUserUseCase = null;
    }


    @Test
    public void cuandoIntroduzcoUnUsuarioCorrectoActualizaUsuario() {
        //Given: Declaración de variables
        User updateUser = new User ("1","Leonel","Messi","14632904R","03/09/2023");

        //When
        updateUserUseCase.execute(updateUser);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).updateUser(updateUser);

    }


    @Test
    public void cuandoIntroduzcoUnUsuarioIncorrectoNoActualizaUsuario() {
        //Given: Declaración de variables
        User invalidUser = null;


        //When
        updateUserUseCase.execute(invalidUser);

        //Then
        Mockito.verify(userRepository, Mockito.never()).updateUser(Mockito.any(User.class));


    }


}