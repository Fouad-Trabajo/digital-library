package com.library.feature.loan.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class SaveLoanUseCase {

    private LoanRepository loanRepository;

    public SaveLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public void execute(Loan loan) {
        if (loan != null) {
            List<Loan> models = loanRepository.getLoans();
            String returnDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            String loanStatus = "finalizado";
            if (models != null) {
                // Busca el préstamo que deseas actualizar y reemplázalo
                for (Loan model : models) {
                    if (model.id.equals(loan.id)) {
                        // Elimina el préstamo existente
                        loanRepository.deleteLoan(loan.id);

                        // Crea una nueva instancia de Loan con los valores actualizados
                        Loan updateLoan = model.updateReturnDate_LoanStatus(returnDate, loanStatus);

                        // Guarda el nuevo préstamo actualizado en el repositorio
                        loanRepository.saveLoan(updateLoan);
                        return;
                    } //Esto es imprescindible para salir del método y no ejecutar nada más
                }
            }
        }
        // Si el préstamo es nulo o no se encontró, simplemente guárdalo como un nuevo préstamo
        loanRepository.saveLoan(loan);
    }

}


