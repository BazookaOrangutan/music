package com.example.music.service;

import com.example.music.model.Track;

import java.util.List;
import java.util.UUID;

/**
 * Сервис управления треками
 */
public interface TrackService {

    /**
     * Создание трека
     *
     * @param track трек
     * @return созданный трек
     */
    Track createTrack(Track track);

    /**
     * Получение трека по его уникальному идентификатору
     *
     * @param id уникальный идентификатор трека
     * @return найденный трек
     */
    Track getTrackById(UUID id);

    /**
     * Обновление трека
     *
     * @param id уникальный идентификатор трека
     * @param track трек
     * @return обновленный трек
     */
    Track updateTrack(UUID id, Track track);

    /**
     * Удаление трека
     *
     * @param id уникальный идентификатор трека
     */
    void deleteTrackById(UUID id);

    /**
     * Получение списка всех треков
     *
     * @return список треков
     */
    List<Track> getAllTracks();
}
