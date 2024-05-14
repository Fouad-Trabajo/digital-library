package com.library.feature.loan.presentation;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.digitalresources.presentation.DigitalBookPresentation;
import com.library.feature.loan.data.LoanDataRepository;
import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.*;
import com.library.feature.user.domain.User;
import com.library.feature.user.presentation.UserPresentation;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LoanPresentation {
    static Scanner input = new Scanner(System.in);

    public static void menuLoan() {

        int opcion;

        do {
            System.out.println("********** MENÚ PRÉSTAMOS **********");
            System.out.println("0. Volver atrás");
            System.out.println("1. Crear préstamo");
            System.out.println("2. Borrar préstamo");
            System.out.println("3. Listado de préstamos");
            System.out.println("4. Mostrar préstamos activos");
            System.out.println("5. Mostrar préstamos finalizados");
            System.out.println("6. Actualizar fecha devolución - Devolver recurso");
            System.out.println("7. Mostrar 1 préstamo mediante id");
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atrás...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un préstamo.");
                    createLoan();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un préstamo");
                    deleteLoan();
                    break;
                case 3:
                    System.out.println("Has seleccionado mostrar todos los préstamos del sistema\n");
                    getLoans();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar los préstamos aún vigentes\n");
                    getLoansActive();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar los préstamos finalizados\n");
                    getFinishedLoans();
                    break;
                case 6:
                    System.out.println("Has seleccionado actualizar la fecha de devolución (devolver recurso)");
                    updateReturnDatePrestamo();
                    break;
                case 7:
                    System.out.println("Has seleccionado mostrar 1 préstamo");
                    getLoan();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void createLoan() {
        System.out.println("Introduce los datos del préstamo");
        User user = UserPresentation.getUser();
        DigitalBook digitalBook = DigitalBookPresentation.getDigitalBook();

        String loanDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String estimatedReturnDate = LocalDateTime.now().plusDays(14).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String id = user.name + "-" + loanDate + "-" + digitalBook.id;

        Loan loan = new Loan(id, loanDate, null, "activo",
                estimatedReturnDate, user, digitalBook);
        SaveLoanUseCase saveLoanUseCase = new SaveLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        saveLoanUseCase.execute(loan);
    }

    public static void deleteLoan() {
        input.nextLine();
        System.out.print("Introduce el id del préstamo que desea eliminar: ");
        String id = input.nextLine();
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        deleteLoanUseCase.execute(id);
        System.out.println("El préstamo con id " + id + " se ha borrado con éxito");
    }

    public static void getLoans() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        List<Loan> loanList = getLoansUseCase.execute();
        for (Loan loan : loanList) {
            System.out.println("\n" + loan);
        }
    }

    public static void getLoansActive() {
        GetLoansActiveUseCase getLoansActiveUseCase = new GetLoansActiveUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));

        List<Loan> loansActive = getLoansActiveUseCase.execute();
        for (Loan loan : loansActive) {
            System.out.println("\n" + loan);
        }
    }

    public static void getFinishedLoans() {
        GetFinishedLoansUseCase getFinishedLoansUseCase = new GetFinishedLoansUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));

        List<Loan> loansFinished = getFinishedLoansUseCase.execute();
        for (Loan loan : loansFinished) {
            System.out.println("\n" + loan);
        }
    }

    public static void updateReturnDatePrestamo() {
        Loan updateLoan = getLoan();
        String returnDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String loanStatus = "finalizado";
        updateLoan.updateReturnDate_LoanStatus(returnDate, loanStatus);

        SaveLoanUseCase saveLoanUseCase = new SaveLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        saveLoanUseCase.execute(updateLoan);
        System.out.println("Libro devuelto");
    }

    public static Loan getLoan() {
        GetLoanUseCase getLoanUseCase = new GetLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        return getLoanUseCase.execute();
    }
}
