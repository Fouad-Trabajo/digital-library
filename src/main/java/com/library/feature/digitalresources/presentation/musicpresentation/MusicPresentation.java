package com.library.feature.digitalresources.presentation.musicpresentation;


import com.library.feature.digitalresources.domain.*;
import com.library.feature.digitalresources.data.musicdata.MusicDataRepository;
import com.library.feature.digitalresources.data.musicdata.local.MusicFileLocalDataSource;
import com.library.feature.digitalresources.domain.music.domain.Music;
import com.library.feature.digitalresources.domain.music.domain.MusicFactory;


import java.util.List;
import java.util.Scanner;

public class MusicPresentation {
    static Scanner input = new Scanner(System.in);

    static MusicFactory musicFactory = new MusicFactory();

    public MusicPresentation(MusicFactory musicFactory) {
    }

    static MusicPresentation musicPresentation = new MusicPresentation(musicFactory);

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
                    musicPresentation.createMusic();
                    break;
                case 2:
                    System.out.println("Has seleccionado obtener un canción.");
                    musicPresentation.getMusic();
                    break;
                case 3:
                    System.out.println("Has seleccionado borrar un canción.");
                    musicPresentation.deleteMusic();
                    break;
                case 4:
                    System.out.println("Has seleccionado obtener un listado de canciones.");
                    musicPresentation.getMusics();
                    break;
                case 5:
                    System.out.println("Has seleccionado actualizar los datos de un canción.");
                    musicPresentation.updateMusic();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    public  void createMusic() {
        input.nextLine();
        System.out.print("Introduce el id: ");
        String id = input.nextLine();
        System.out.print("Nombre del autor de la cancion: ");
        String author = input.nextLine();

        System.out.print("Duracion de la canción: ");
        String duracion = input.nextLine();

        Music music = new Music(id, author, duracion);
        CreateDigitalResourceUseCase createDigitalResourceUseCase = musicFactory.buildCreateResource();
        createDigitalResourceUseCase.execute(music);
    }

    public  Music getMusic() {
        GetDigitalResourceUseCase getDigitalResourceUseCase = musicFactory.buildGetResource();
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

    public  void deleteMusic(){
        input.nextLine();
        System.out.print("Introdue el id de la canción que quieres borrar: ");
        String id = input.nextLine();
        DeleteDigitalResourceUseCase deleteDigitalResourceUseCase = musicFactory.buildDeleteResource();
        deleteDigitalResourceUseCase.execute(id);
        System.out.println("La canción con id " + id + " ha sido borrado exitosamente");
    }

    public  void getMusics() {
        GetDigitalResourcesUseCase getDigitalResourcesUseCase = musicFactory.buildGetResourcres();
        List<DigitalResources> digitalBooksList = getDigitalResourcesUseCase.execute();
        for (DigitalResources music : digitalBooksList) {
            System.out.println(music);
        }
    }

    public  void updateMusic() {
        Music music = getMusic();
        UpdateDigitalResourceUseCase updateDigitalResourceUseCase = musicFactory.buildUpdateResource();
        input.nextLine();
        System.out.print("Nombre del autor de la cancion: ");
        String author = input.nextLine();
        System.out.print("Duracion de la canción: ");
        String duracion = input.nextLine();
        DigitalResources digitalResources = new Music(music.id, author,duracion);
        updateDigitalResourceUseCase.execute(digitalResources);
    }
}