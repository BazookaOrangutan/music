package com.example.music.exception.handler;

import com.example.music.exception.PlaylistNotFoundException;
import com.example.music.exception.TrackNotFoundException;
import com.example.music.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TrackNotFoundException.class})
    public ResponseEntity<String> handleTrackNotFound(TrackNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({PlaylistNotFoundException.class})
    public ResponseEntity<String> handlePlaylistNotFound(PlaylistNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
