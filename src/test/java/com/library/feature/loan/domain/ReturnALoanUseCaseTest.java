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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ReturnALoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    ReturnALoanUseCase returnALoanUseCase;

    @BeforeEach
    void setUp() {
        returnALoanUseCase = new ReturnALoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        returnALoanUseCase = null;
    }


    @Test
    public void cuandoActualizoLaFechaDeDevolucionDelLoan(){
        //Given: Declaración de variables
        User user = new User ("10", "Fouad","Aharchi","12461564L","12/12/2023");
        DigitalBook digitalBook = new DigitalBook("14","Tolkien","175","Fantasia",
                "Garvof","La vuelta al mundo");
        String loanDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String returnDate =  LocalDateTime.now().plusDays(14).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        Loan loan = new Loan("1", loanDate, returnDate, user, digitalBook);

        //When
        loanRepository.returnALoan(loan);

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).returnALoan(loan);
    }
}