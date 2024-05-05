package com.library.feature.loan.presentation;

import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.domain.DigitalBook;
import com.library.feature.loan.data.LoanDataRepository;
import com.library.feature.loan.data.local.LoanFileLocalDataSource;
import com.library.feature.loan.domain.*;
import com.library.feature.user.data.local.UserFileLocalDataSource;
import com.library.feature.user.domain.User;

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
            System.out.println("6. Actualizar préstamo");
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
                    System.out.println("Has seleccionado mostrar todos los préstamos del sistema");
                    getPrestamos();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar los préstamos aún vigentes");
                    getPrestamosActivos();
                    break;
                case 5:
                    System.out.println("Has seleccionado mostrar los préstamos finalizados");
                    getPrestamosFinalizados();
                    break;
                case 6:
                    System.out.println("Has seleccionado actualizar un préstamo");
                    updatePrestamo();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }


    static UserFileLocalDataSource userFileLocalDataSource = new UserFileLocalDataSource();
    static DigitalBookFileLocalDataSource digitalBookFileLocalDataSource = new DigitalBookFileLocalDataSource();

    public static void createLoan() {
        System.out.println("Introduce los datos del préstamo que quires dar de alta");
        System.out.print("Introduce el id: ");
        String id = input.next();
        System.out.print("Introduce la fecha de inicio del préstamo: ");
        String startDate = input.next();
        System.out.print("Introduce la fecha de fin del préstamo: ");
        String endDate = input.next();
        System.out.print("Introduce el estado del préstamo: (activo/finalizado): ");
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

    public static void getPrestamos() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        List<Loan> prestamos = getLoansUseCase.execute();
        System.out.println(prestamos);
    }

    public static void getPrestamosActivos() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> prestamos = getLoansUseCase.execute();
        for (Loan prestamo : prestamos) {
            if (prestamo.loanStatus.equals("activo")) {
                System.out.println(prestamo);
            }
        }
    }

    public static void getPrestamosFinalizados() {
        GetLoansUseCase getLoansUseCase = new GetLoansUseCase(new LoanDataRepository(
                new LoanFileLocalDataSource()));
        List<Loan> prestamos = getLoansUseCase.execute();
        for (Loan prestamo : prestamos) {
            if (prestamo.loanStatus.equals("finalizado")) {
                System.out.println(prestamo);
            }
        }
    }

    public static void updatePrestamo(){
        System.out.print("Introduce el id del préstamo que quieres actualizar: ");
        String id= input.next();
        UpdateLoanUseCase updateLoanUseCase = new UpdateLoanUseCase(
                new LoanDataRepository(new LoanFileLocalDataSource()));
        System.out.println("Modifica los datos que quieras:");
        System.out.print("Introduce la fecha de inicio del préstamo: ");
        String startDate = input.next();
        System.out.print("Introduce la fecha de fin del préstamo: ");
        String endDate = input.next();
        System.out.print("Introduce el estado del préstamo: (activo/finalizado): ");
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

        Loan loan = new Loan(id,startDate,endDate, loanStatus, user, digitalBook);
        updateLoanUseCase.execute(loan);
    }

}
