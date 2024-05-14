package com.library.feature.loan.domain;



import java.util.Scanner;

public class GetLoanUseCase {

    private LoanRepository loanRepository;

    public GetLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute() {
        Scanner input = new Scanner(System.in);
        Loan loan;
        do {
            System.out.print("Introduce el id del préstamo: ");
            String id = input.nextLine();
            loan = loanRepository.getLoan(id);
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
