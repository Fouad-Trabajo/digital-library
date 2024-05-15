package com.library.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetUsersUseCaseTest {

    @Mock
    UserRepository userRepository;
    GetUsersUseCase getUsersUseCase;

    @BeforeEach
    void setUp() {
        getUsersUseCase = new GetUsersUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        userRepository = null;
    }

    @Test
    public void cuandoObtengoLaListaYTieneModelosUser(){
        //Given: Declaración de variables
        List<User> usersExpected = new ArrayList<>();
        usersExpected.add(new  User("1", "Gabriel", "Polo", "12360138M", "10/05/2014"));
        usersExpected.add(new User("2", "Marcos", "Murial", "14462902E", "11/11/2021"));
        Mockito.when(userRepository.getUsers()).thenReturn(usersExpected);


        //When
        List<User> userReceived = getUsersUseCase.execute();

        //Then
        assertEquals(usersExpected.size(), usersExpected.size());

    }

    @Test
    public void cuandoObtengoLaListaYEsNullEstaVacia(){
        //Given: Declaración de variables
        List<User> usersExpectedEmpty = new ArrayList<>();
        Mockito.when(userRepository.getUsers()).thenReturn(usersExpectedEmpty);


        //When
        List<User> usersReceivedEmpty = getUsersUseCase.execute();


        //Then
        assertEquals(0,usersReceivedEmpty.size());
    }
}