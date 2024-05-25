package com.library.feature.loan.domain;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;
import com.library.feature.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveLoanUseCaseTest {


    @Mock
    LoanRepository loanRepository;
    SaveLoanUseCase saveLoanUseCase;

    @BeforeEach
    void setUp() {
        saveLoanUseCase = new SaveLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        saveLoanUseCase = null;
    }

    @Test
    public void cuandoReciboUnLoanEsteSeGuardaCorrectamente(){
        //Given: Declaración de variables
        User user = new User ("10", "Fouad","Aharchi","12461564L","12/12/2023");
        DigitalBook digitalBook = new DigitalBook("14","Tolkien","175","Fantasia",
                "Garvof","La vuelta al mundo");
        Loan loan = new Loan ("1",user, digitalBook);


        //When
        saveLoanUseCase.execute(loan);

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).saveLoan(loan);
    }
}