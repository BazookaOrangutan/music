package com.example.music.mapper;

import com.example.music.dto.request.TrackRequest;
import com.example.music.dto.response.TrackResponse;
import com.example.music.model.Track;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TrackMapper {

    TrackResponse toResponse(Track track);

    Track toTrack(TrackRequest trackRequest);

}