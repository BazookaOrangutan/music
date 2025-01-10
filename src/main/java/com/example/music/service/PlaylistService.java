package com.example.music.service;

import com.example.music.model.Playlist;
import com.example.music.model.Track;

import java.util.List;
import java.util.UUID;

/**
 * Сервис управления плейлистами
 */
public interface PlaylistService {

    /**
     * Создание плейлиста
     *
     * @param playlist плейлист
     * @return созданный плейлист
     */
    Playlist createPlaylist(Playlist playlist);

    /**
     * Получение плейлиста по его уникальному идентификатору
     *
     * @param id уникальный идентификатор плейлиста
     * @return найденный плейлист
     */
    Playlist getPlaylistById(UUID id);

    /**
     * Обновление плейлиста
     *
     * @param id уникальный идентификатор плейлиста
     * @param playlist плейлист
     * @return обновленный плейлист
     */
    Playlist updatePlaylist(UUID id, Playlist playlist);

    /**
     * Удаление плейлиста
     *
     * @param id уникальный идентификатор плейлиста
     */
    void deletePlaylistById(UUID id);

    /**
     * Получение списка всех плейлистов
     *
     * @return список плейлистов
     */
    List<Playlist> getAllPlaylists();

    /**
     * Добавление трека в плейлист
     *
     * @param playlistId уникальный идентификатор плейлиста
     * @param track добавляемый трек
     * @return обновленный плйелист
     */
    Playlist addTrack(UUID playlistId, Track track);
}
