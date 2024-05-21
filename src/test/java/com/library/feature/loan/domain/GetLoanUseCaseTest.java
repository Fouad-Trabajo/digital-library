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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    GetLoanUseCase getLoanUseCase;

    @BeforeEach
    void setUp() {
        getLoanUseCase = new GetLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        getLoanUseCase = null;
    }

    @Test
    public void cuandoIntroduzcoElIdentificadorCorrectoObtengoUnLoan(){
        //Given: Declaración de variables
        String validId ="5";
        User user = new User("2","Marcos","Alameda","12470438L","08-04-2015");
        DigitalBook digitalBook = new DigitalBook("3","Tolkien","200","Romance",
                "Garvof","La vuelta al mundo");
        Loan loanExpected = new Loan ("5",user, digitalBook);
        Mockito.when(loanRepository.getLoan(validId)).thenReturn(loanExpected);

        //When
        Loan loanReceived = getLoanUseCase.execute(validId);

        //Then
        Assertions.assertEquals(loanReceived.id, "5");

        //Comparar los atributos del usuario
        Assertions.assertEquals(loanReceived.user.id, user.id);
        Assertions.assertEquals(loanReceived.user.name, user.name);
        Assertions.assertEquals(loanReceived.user.surname, user.surname);
        Assertions.assertEquals(loanReceived.user.dni, user.dni);
        Assertions.assertEquals(loanReceived.user.dateInscription, user.dateInscription);

        //Comparar los atributos del digitalResource
        Assertions.assertEquals(loanReceived.digitalResources.id, digitalBook.id);
        Assertions.assertEquals(loanReceived.digitalResources.author, digitalBook.author);
        Assertions.assertEquals(loanReceived.digitalResources.numberPages, digitalBook.numberPages);
        Assertions.assertEquals(loanReceived.digitalResources.genre, digitalBook.genre);
        Assertions.assertEquals(loanReceived.digitalResources.editorial, digitalBook.editorial);
        Assertions.assertEquals(loanReceived.digitalResources.description, digitalBook.description);
    }

    @Test
    public void cuandoIntroduczcoUnIdentificadorIncorrectoDevuelveNull(){
        //Given: Declaración de variables
        String invalidId="kk";
        Mockito.when(loanRepository.getLoan(invalidId)).thenReturn(null);

        //When
        Loan loanReceived = getLoanUseCase.execute(invalidId);

        //Then
        Assertions.assertNull(loanReceived);
    }
}