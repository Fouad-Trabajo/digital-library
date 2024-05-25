package com.library.feature.digitalresources.presentation.musicpresentation;


import com.library.feature.digitalresources.domain.*;
import com.library.feature.digitalresources.data.musicdata.MusicDataRepository;
import com.library.feature.digitalresources.data.musicdata.local.MusicFileLocalDataSource;
import com.library.feature.digitalresources.domain.music.domain.Music;


import java.util.List;
import java.util.Scanner;

public class MusicPresentation {
    static Scanner input = new Scanner(System.in);

    //static MusicPresentation musicPresentation = new MusicPresentation();

    public static void menuMusic() {
        int opcion;

        do {
            System.out.println("********** MENÚ MÚSICA **********");
            System.out.println("0. Volver atrás                 *");
            System.out.println("1. Crear canción                *");
            System.out.println("2. Obtener 1 canción            *");
            System.out.println("3. Borrar 1 canción             *");
            System.out.println("4. Obtener listado de canciones *");
            System.out.println("5. Actualizar canción           *");
            System.out.println("*********************************");
            System.out.print("Elige una opción: ");

            opcion = input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Volviendo atras...");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un canción.");
                    createMusic();
                    break;
                case 2:
                    System.out.println("Has seleccionado obtener un canción.");
                    getMusic();
                    break;
                case 3:
                    System.out.println("Has seleccionado borrar un canción.");
                    deleteMusic();
                    break;
                case 4:
                    System.out.println("Has seleccionado obtener un listado de canciones.");
                    getMusics();
                    break;
                case 5:
                    System.out.println("Has seleccionado actualizar los datos de un canción.");
                    updateMusic();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void createMusic() {
        input.nextLine();
        System.out.print("Introduce el id: ");
        String id = input.nextLine();
        System.out.print("Nombre del autor de la cancion: ");
        String author = input.nextLine();

        System.out.print("Duracion de la canción: ");
        String duracion = input.nextLine();

        Music music = new Music(id, author, duracion);
        CreateDigitalResourceUseCase createDigitalResourceUseCase = new CreateDigitalResourceUseCase(
                new MusicDataRepository(new MusicFileLocalDataSource()));
        createDigitalResourceUseCase.execute(music);
    }

    public static Music getMusic() {
        GetDigitalResourceUseCase getDigitalResourceUseCase = new GetDigitalResourceUseCase(
                new MusicDataRepository(new MusicFileLocalDataSource()));
        Music music;
        do {
            System.out.print("Introduce el id de la canción: ");
            String id = input.next();
            music = (Music) getDigitalResourceUseCase.execute(id);
            if (music == null) {
                System.out.println("El id " + id + " que has introducido no corresponde a ningúna canción");
            } else {
                System.out.println("\n" + music);
            }
        } while (music == null);
        return music;
    }

    public static void deleteMusic(){
        input.nextLine();
        System.out.print("Introdue el id de la canción que quieres borrar: ");
        String id = input.nextLine();
        DeleteDigitalResourceUseCase deleteDigitalResourceUseCase = new DeleteDigitalResourceUseCase(
                new MusicDataRepository(new MusicFileLocalDataSource()));
        deleteDigitalResourceUseCase.execute(id);
        System.out.println("La canción con id " + id + " ha sido borrado exitosamente");
    }

    public static void getMusics() {
        GetDigitalResourcesUseCase getDigitalResourcesUseCase = new GetDigitalResourcesUseCase(
                new MusicDataRepository(new MusicFileLocalDataSource()));
        List<DigitalResources> digitalBooksList = getDigitalResourcesUseCase.execute();
        for (DigitalResources music : digitalBooksList) {
            System.out.println(music);
        }
    }

    public static void updateMusic() {
        Music music = getMusic();
        UpdateDigitalResourceUseCase updateDigitalResourceUseCase = new UpdateDigitalResourceUseCase(
                new MusicDataRepository(new MusicFileLocalDataSource()));

        input.nextLine();
        System.out.print("Nombre del autor de la cancion: ");
        String author = input.nextLine();

        System.out.print("Duracion de la canción: ");
        String duracion = input.nextLine();
        DigitalResources digitalResources = new Music(music.id, author,duracion);
        updateDigitalResourceUseCase.execute(digitalResources);
    }

}
