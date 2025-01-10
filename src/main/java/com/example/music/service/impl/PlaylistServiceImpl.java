package com.example.music.service.impl;

import com.example.music.exception.PlaylistNotFoundException;
import com.example.music.exception.TrackNotFoundException;
import com.example.music.model.Playlist;
import com.example.music.model.Track;
import com.example.music.repository.PlaylistRepository;
import com.example.music.repository.TrackRepository;
import com.example.music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistById(UUID id) {

        return playlistRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException(id));
    }

    @Override
    public Playlist updatePlaylist(UUID id, Playlist playlist) {

        if(!playlistRepository.existsById(id)) {
            throw new TrackNotFoundException(id);
        }

        playlist.setId(id);

        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylistById(UUID id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist addTrack(UUID playlistId, Track track) {

        Playlist playlist = getPlaylistById(playlistId);
        playlist.getTracks().add(track);
        track.getPlaylists().add(playlist);

        return playlistRepository.save(playlist);
    }
}
