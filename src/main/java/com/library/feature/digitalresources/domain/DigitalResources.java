package com.library.feature.digitalresources.domain;

public class DigitalResources {

    public final String id, author;

    public DigitalResources(String id, String author) {
        this.id = id;
        this.author = author;
    }

    @Override
    public String toString() {
        return "DigitalResources{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                '}' + "'\n";
    }
}
