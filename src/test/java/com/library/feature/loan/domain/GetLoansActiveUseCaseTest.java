package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;
import com.library.feature.user.domain.User;
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
class GetLoansActiveUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    GetLoansUseCase getLoansUseCase;
    @BeforeEach
    void setUp() {
        getLoansUseCase = new GetLoansUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        getLoansUseCase = null;
    }

    @Test
    public void cuandoObtengoLaListaCorrectaDePrestamosActivos() {
        //Given: Declaración de variables
        List<Loan> loansExpected = new ArrayList<>();
        User user = new User("10", "Fouad", "Aharchi", "12461564L", "12/12/2023");
        DigitalBook digitalBook = new DigitalBook("14", "Tolkien", "175", "Fantasia",
                "Garvof", "La vuelta al mundo");
        loansExpected.add(new Loan("1", user, digitalBook));
        loansExpected.add(new Loan("2", user, digitalBook));
        Mockito.when(loanRepository.getLoans()).thenReturn(loansExpected);

        //When
        List<Loan> loansReceived = getLoansUseCase.execute();

        //Then
        Assertions.assertEquals(loansExpected.size(), loansReceived.size());
        for (int i = 0; i < loansExpected.size(); i++) {
            Loan expected = loansExpected.get(i);
            Loan received = loansReceived.get(i);

            Assertions.assertEquals(expected.id, received.id);

            //Comparar los atributos del usuario
            Assertions.assertEquals(expected.user.id, user.id);
            Assertions.assertEquals(expected.user.name, user.name);
            Assertions.assertEquals(expected.user.surname, user.surname);
            Assertions.assertEquals(expected.user.dni, user.dni);
            Assertions.assertEquals(expected.user.dateInscription, user.dateInscription);

            //Comparar los atributos del digitalResource
            Assertions.assertEquals(expected.digitalResources.id, digitalBook.id);
            Assertions.assertEquals(expected.digitalResources.author, digitalBook.author);
            Assertions.assertEquals(expected.digitalResources.numberPages, digitalBook.numberPages);
            Assertions.assertEquals(expected.digitalResources.genre, digitalBook.genre);
            Assertions.assertEquals(expected.digitalResources.editorial, digitalBook.editorial);
            Assertions.assertEquals(expected.digitalResources.description, digitalBook.description);
        }

    }

    @Test
    public void cuandoObtengoLaListaDePrestamosActivosYEstaVacia() {
        //Given: Declaración de variables
        List<Loan> loansExpected = new ArrayList<>();
        Mockito.when(loanRepository.getLoans()).thenReturn(loansExpected);

        //Then
        List<Loan> loanRecivedEmpty = getLoansUseCase.execute();

        //Then
        Assertions.assertEquals(0, loanRecivedEmpty.size());
    }




}