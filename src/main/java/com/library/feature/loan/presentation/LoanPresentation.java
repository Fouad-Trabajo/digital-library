package com.library.feature.loan.presentation;

import com.library.feature.digitalresources.domain.digitalbook.DigitalBook;
import com.library.feature.digitalresources.presentation.DigitalBookPresentation;
import com.library.feature.loan.data.LoanDataRepository;
import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.*;
import com.library.feature.user.domain.User;
import com.library.feature.user.presentation.UserPresentation;

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
            System.out.println("6. Actualizar fecha devolución");
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
                    System.out.println("Has seleccionado actualizar la fecha de devolución del préstamo");
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
        input.nextLine(); //Consumir línea pendiente
        System.out.println("Introduce los datos del préstamo que quieres dar de alta");
        System.out.print("Introduce el id: ");
        String id = input.nextLine();
        System.out.print("Introduce la fecha del préstamo (cuando se formalizó el prestamo): ");
        String loanDate = input.nextLine();
        /** Introduce id del usuario */
        User user = UserPresentation.getUser();
        /** Introduce id del libro digital */
        DigitalBook digitalBook = DigitalBookPresentation.getDigitalBook();

        Loan loan = new Loan(id, loanDate, null, user, digitalBook);
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        createLoanUseCase.execute(loan);
    }

    public static void deleteLoan() {
        System.out.print("Introduce el id del préstamo que desea eliminar: ");
        String id = input.next();
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        deleteLoanUseCase.execute(id);
        System.out.println("El préstamo con id " + id + " se ha borrado con éxito");
    }

    public static List<Loan> getLoans() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        List<Loan> loanList = getLoansUseCase.execute();
        for (Loan loan : loanList) {
            System.out.println("\n" + loan);
        }
        return loanList;
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
        Loan loan = getLoan();
        input.nextLine(); //Consumir línea pendiente
        System.out.print("Modifica la fecha de devolución: ");
        String returnDate = input.nextLine();
        Loan loanUpdate = new Loan(loan.id, loan.loanDate, returnDate,
                loan.user, loan.digitalBook);

        UpdateReturnDateLoanUseCase updateReturnDateLoanUseCase = new UpdateReturnDateLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        updateReturnDateLoanUseCase.execute(loanUpdate);
    }

    public static Loan getLoan() {
        GetLoanUseCase getLoanUseCase = new GetLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        return getLoanUseCase.execute();
    }
}
