package com.library.feature.digitalresources.domain;

public class DigitalBook extends DigitalResources {

    public final String numberPages, genre, editorial, description;

    public DigitalBook(String id, String author, String numberPages,
                       String genre, String editorial, String description) {
        super(id, author);
        this.numberPages = numberPages;
        this.genre = genre;
        this.editorial = editorial;
        this.description = description;
    }
}
