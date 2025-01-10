--liquibase formatted sql
--changeset Nikolay Chernichko:4
CREATE TABLE playlist_track
(
    playlist_id uuid NOT NULL,
    track_id uuid NOT NULL,
    CONSTRAINT playlist_id_fk FOREIGN KEY (playlist_id) REFERENCES playlist(id),
    CONSTRAINT track_id_fk FOREIGN KEY (track_id) REFERENCES track(id)
);

--rollback drop table playlist_track;
