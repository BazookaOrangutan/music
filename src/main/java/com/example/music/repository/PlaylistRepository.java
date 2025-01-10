package com.example.music.repository;

import com.example.music.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {
}
