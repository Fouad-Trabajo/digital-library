package com.library.feature.digitalresources.domain.music.domain;

import com.library.feature.digitalresources.domain.DigitalResources;

public class Music extends DigitalResources {

    public final String duration;

    public Music(String id, String author, String duration ) {
        super(id, author);
        this.duration = duration;

    }

    @Override
    public String toString() {
        return "Music{" +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", duration='" + duration + '\'' +
                '}' + "'\n";
    }
}
