package com.example.music.controller;

import com.example.music.dto.request.PlaylistRequest;
import com.example.music.dto.response.PlaylistResponse;
import com.example.music.mapper.PlaylistMapper;
import com.example.music.model.Playlist;
import com.example.music.model.Track;
import com.example.music.service.PlaylistService;
import com.example.music.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.music.constants.EndpointConstants.URL_PLAYLIST_API;

@RestController
@RequiredArgsConstructor
@RequestMapping(URL_PLAYLIST_API)
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;
    private final TrackService trackService;

    @PostMapping
    private PlaylistResponse createPlaylist(@RequestBody PlaylistRequest playlistRequest) {
        return playlistMapper.toResponse(playlistService.createPlaylist(playlistMapper.toPlaylist(playlistRequest)));
    }

    @GetMapping("{id}")
    private PlaylistResponse getPlaylist(@PathVariable UUID id) {
        return playlistMapper.toResponse(playlistService.getPlaylistById(id));
    }

    @GetMapping
    private List<PlaylistResponse> getPlaylists() {
        return playlistService.getAllPlaylists().stream().map(playlistMapper::toResponse).toList();
    }

    @PutMapping("{id}")
    private PlaylistResponse updatePlaylist(@PathVariable UUID id, @RequestBody PlaylistRequest playlistRequest) {
        return playlistMapper.toResponse(playlistService.updatePlaylist(id, playlistMapper.toPlaylist(playlistRequest)));
    }

    @DeleteMapping("{id}")
    private void deletePlaylist(@PathVariable UUID id) {
        playlistService.deletePlaylistById(id);
    }

    @PatchMapping("{playlistId}/tracks/{trackId}")
    private PlaylistResponse patchPlaylist(@PathVariable UUID playlistId, @PathVariable UUID trackId) {
        return playlistMapper.toResponse(playlistService.addTrack(playlistId, trackService.getTrackById(trackId)));
    }
}
