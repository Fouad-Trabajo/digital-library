package com.library.feature.loan.presentation;

import com.library.feature.digitalresources.domain.DigitalResources;
import com.library.feature.digitalresources.presentation.DigitalResourcesPresentation;
import com.library.feature.loan.domain.*;
import com.library.feature.user.domain.User;
import com.library.feature.user.domain.UserFactory;
import com.library.feature.user.presentation.UserPresentation;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LoanPresentation {
    static Scanner input = new Scanner(System.in);
    static LoanFactory loanFactory = new LoanFactory();

    public LoanPresentation(LoanFactory loanFactory) {
    }

    static LoanPresentation loanPresentation = new LoanPresentation(loanFactory);

    public static void menuLoan() {

        int opcion;

        do {
            System.out.println("***************** MENÚ PRÉSTAMOS *****************");
            System.out.println("0. Volver atrás                                  *");
            System.out.println("1. Crear préstamo                                *");
            System.out.println("2. Borrar préstamo                               *");
            System.out.println("3. Listado de préstamos                          *");
            System.out.println("4. Mostrar préstamos activos                     *");
            System.out.println("5. Mostrar préstamos finalizados                 *");
            System.out.println("6. Devolver recurso - Actualizar fecha           *");
            System.out.println("7. Mostrar 1 préstamo mediante id                *");
            System.out.println("**************************************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atrás...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un préstamo.");
                    loanPresentation.createLoan();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un préstamo");
                    loanPresentation.deleteLoan();
                    break;
                case 3:
                    System.out.println("Has seleccionado mostrar todos los préstamos del sistema\n");
                    loanPresentation.getLoans();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar los préstamos aún vigentes\n");
                    loanPresentation.getLoansActive();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar los préstamos finalizados\n");
                    loanPresentation.getFinishedLoans();
                    break;
                case 6:
                    System.out.println("Has seleccionado actualizar la fecha de devolución (devolver recurso)");
                    loanPresentation.updateReturnDatePrestamo();
                    break;
                case 7:
                    System.out.println("Has seleccionado mostrar 1 préstamo");
                    loanPresentation.getLoan();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public void createLoan() {
        System.out.println("Introduce los datos del préstamo");
        UserFactory userFactory = new UserFactory();
        UserPresentation userPresentation = new UserPresentation(userFactory);
        User user = userPresentation.getUser();
        DigitalResources digitalResources = DigitalResourcesPresentation.selectResource();

        String loanDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String id = user.name + "-" + loanDate + "-" + digitalResources.id;

        Loan loan = new Loan(id, user, digitalResources);
        System.out.println("ESTE ES EL PRÉSTAMO QUE ACABAS DE CREAR\n" + loan);
        SaveLoanUseCase saveLoanUseCase = loanFactory.buildSaveLoan();
        saveLoanUseCase.execute(loan);
    }

    public void deleteLoan() {
        input.nextLine();
        System.out.print("Introduce el id del préstamo que desea eliminar: ");
        String id = input.nextLine();
        DeleteLoanUseCase deleteLoanUseCase = loanFactory.buildDeleteLoan();
        deleteLoanUseCase.execute(id);
        System.out.println("El préstamo con id " + id + " se ha borrado con éxito");
    }

    public void getLoans() {
        GetLoansUseCase getLoansUseCase = loanFactory.buildGetLoans();
        List<Loan> loanList = getLoansUseCase.execute();
        for (Loan loan : loanList) {
            System.out.println("\n" + loan);
        }
    }

    public void getLoansActive() {
        GetLoansActiveUseCase getLoansActiveUseCase = loanFactory.buildGetActiveLoans();
        List<Loan> loansActive = getLoansActiveUseCase.execute();
        for (Loan loan : loansActive) {
            System.out.println("\n" + loan);
        }
        if (loansActive.isEmpty()) {
            System.out.println("No hay préstamos vigentes. \n" +
                    "Todos los préstamos han sido devueltos");
        }
    }

    public void getFinishedLoans() {
        GetFinishedLoansUseCase getFinishedLoansUseCase = loanFactory.buildGetFinishedLoans();
        List<Loan> loansFinished = getFinishedLoansUseCase.execute();
        for (Loan loan : loansFinished) {
            System.out.println("\n" + loan);
        }
        if (loansFinished.isEmpty()) {
            System.out.println("Todos los préstamos siguen vigentes. \n" +
                    "Los libros todavía no se han devuelto");
        }
    }

    public void updateReturnDatePrestamo() {
        Loan updateLoan = loanPresentation.getLoan();
        ReturnALoanUseCase returnALoanUseCase = loanFactory.buildReturnALoan();
        returnALoanUseCase.execute(updateLoan.id);
        System.out.println("Libro devuelto");
    }

    public Loan getLoan() {
        GetLoanUseCase getLoanUseCase = loanFactory.buildGetLoan();
        Loan loan;
        do {
            input.nextLine();
            System.out.print("Introduce el id del préstamo: ");
            String id = input.nextLine();
            loan = getLoanUseCase.execute(id);
            if (loan == null) {
                System.out.println("El id " + id + " que estás buscando no corresponde" +
                        "a ningún prestamo dado de alta en el sistema");
            } else {
                System.out.println("\n" + loan);
            }
        } while (loan == null);
        return loan;
    }
}