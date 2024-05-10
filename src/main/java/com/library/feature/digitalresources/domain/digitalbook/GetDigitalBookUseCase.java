package com.library.feature.digitalresources.domain.digitalbook;

import com.library.feature.digitalresources.data.DigitalBookDataRepository;
import com.library.feature.digitalresources.data.local.DigitalBookFileLocalDataSource;

import java.util.Scanner;

public class GetDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public GetDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public DigitalBook execute() {
        Scanner input = new Scanner(System.in);
        DigitalBook digitalBook;
        do {
            System.out.print("Introduce el id del libro que quieres ver: ");
            String id = input.nextLine();
            digitalBook = digitalBookRepository.getDigitalBook(id);
            if (digitalBook == null) {
                System.out.println("El id " + id + " que has introducido no corresponde a ningún libro");
            } else {
                System.out.println("\n" + digitalBook);
            }
        } while (digitalBook == null);
        return digitalBook;
    }
}
