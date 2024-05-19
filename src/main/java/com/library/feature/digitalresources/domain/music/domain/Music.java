package com.library.feature.digitalresources.domain.music.domain;

import com.library.feature.digitalresources.domain.DigitalResources;

public class Music extends DigitalResources {

    public final String duration, genere;

    public Music(String id, String author, String duration, String genere) {
        super(id, author);
        this.duration = duration;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Music{" +
                "duration='" + duration + '\'' +
                ", genere='" + genere + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                "} " + super.toString();
    }
}
