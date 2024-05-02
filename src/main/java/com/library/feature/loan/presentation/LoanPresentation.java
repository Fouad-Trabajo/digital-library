package com.library.feature.loan.presentation;

import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.digitalresources.presentation.DigitalBookPresentation;
import com.library.feature.loan.data.LoanDataRepository;
import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.CreateLoanUseCase;
import com.library.feature.loan.domain.DeleteLoanUseCase;
import com.library.feature.loan.domain.Loan;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.CreateUserUseCase;
import com.library.feature.user.domain.User;
import com.library.feature.user.presentation.UserPresentation;

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
            System.out.println("**************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Has seleccionado salir. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un préstamo.");
                    createLoan();
                    break;
                case 2:
                    System.out.println("Has seleccionado borrar un préstamo");
                    deleteLoan();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }


    public static void createLoan() {
        UserFileLocalDataSource userFileLocalDataSource = new UserFileLocalDataSource();
        DigitalBookFileLocalDataSource digitalBookFileLocalDataSource = new DigitalBookFileLocalDataSource();

        System.out.println("Introduce los datos del préstamo que quires dar de alta");
        System.out.print("Introduce el id: ");
        String id = input.next();
        System.out.print("Introduce la fecha de inicio del préstamo: ");
        String startDate = input.next();
        System.out.print("Introduce la fecha de fin del préstamo: ");
        String endDate = input.next();
        System.out.print("Introduce el estado del préstamo: (activo/cerrado): ");
        String loanStatus = input.next();
        User user;
        do {
            System.out.print("Introduce el id del usuario relacionado con el préstamo: ");
            String idUser = input.next();
            user = userFileLocalDataSource.findById(idUser);
            if (user == null) {
                System.out.println("Usuario no registrado en el sistema, introduce un id correcto");
            }
        } while (user == null);

        DigitalBook digitalBook;
        do {
            System.out.print("Introduce el id del libro solicitado por el usuario: ");
            String idDigitalBook = input.next();
            digitalBook = digitalBookFileLocalDataSource.findById(idDigitalBook);
            if (digitalBook == null) {
                System.out.println("Libro no registrado en el sistema, introduce un id correcto");
            }

        } while (digitalBook == null);

        Loan loan = new Loan(id, startDate, endDate, loanStatus, user, digitalBook);
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


}
