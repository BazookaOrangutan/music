package com.example.music.service.impl;

import com.example.music.exception.TrackNotFoundException;
import com.example.music.model.Track;
import com.example.music.repository.TrackRepository;
import com.example.music.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;


    @Override
    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(UUID id) {

        return trackRepository.findById(id)
                .orElseThrow(() -> new TrackNotFoundException(id));
    }

    @Override
    public Track updateTrack(UUID id, Track track) {

        if(!trackRepository.existsById(id)) {
            throw new TrackNotFoundException(id);
        }

        track.setId(id);

        return trackRepository.save(track);
    }

    @Override
    public void deleteTrackById(UUID id) {
        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
