package com.example.music.mapper;

import com.example.music.dto.request.PlaylistRequest;
import com.example.music.dto.response.PlaylistResponse;
import com.example.music.model.Playlist;
import com.example.music.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    PlaylistResponse toResponse(Playlist playlist);

    Playlist toPlaylist(PlaylistRequest playlistRequest);

    @AfterMapping
    default void setOwner(@MappingTarget PlaylistResponse playlistResponse, Playlist playlist) {
        playlistResponse.setOwnerId(Optional.ofNullable(playlist.getOwner()).map(User::getId).orElse(null));
    }
}
