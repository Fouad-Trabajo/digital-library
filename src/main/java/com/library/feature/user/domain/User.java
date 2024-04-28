package com.library.feature.user.domain;

public class User {

    public final String id, name, surname, dni, dateInscription;

    public User(String id, String name, String surname, String dni, String dateInscription) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                '}';
    }
}
