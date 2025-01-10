package com.example.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException(UUID id) {
        super("Playlist not found with ID: " + id);
    }
}
