package com.example.music.controller;

import com.example.music.dto.request.TrackRequest;
import com.example.music.dto.response.TrackResponse;
import com.example.music.mapper.TrackMapper;
import com.example.music.model.Track;
import com.example.music.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.music.constants.EndpointConstants.URL_TRACK_API;

@RestController
@RequiredArgsConstructor
@RequestMapping(URL_TRACK_API)
public class TrackController {

    private final TrackService trackService;
    private final TrackMapper trackMapper;

    @PostMapping
    private TrackResponse createTrack(@RequestBody TrackRequest trackRequest) {
        return trackMapper.toResponse(trackService.createTrack(trackMapper.toTrack(trackRequest)));
    }

    @GetMapping("{id}")
    private TrackResponse getTrack(@PathVariable UUID id) {
        return trackMapper.toResponse(trackService.getTrackById(id));
    }

    @GetMapping
    private List<TrackResponse> getTracks() {
        return trackService.getAllTracks().stream().map(trackMapper::toResponse).toList();
    }

    @PutMapping("{id}")
    private TrackResponse updateTrack(@PathVariable UUID id, @RequestBody TrackRequest trackRequest) {
        return trackMapper.toResponse(trackService.updateTrack(id, trackMapper.toTrack(trackRequest)));
    }

    @DeleteMapping("{id}")
    private void deleteTrack(@PathVariable UUID id) {
        trackService.deleteTrackById(id);
    }
}
