package com.example.music.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class PlaylistResponse {

    private UUID id;
    private String title;
    private UUID ownerId;
}
