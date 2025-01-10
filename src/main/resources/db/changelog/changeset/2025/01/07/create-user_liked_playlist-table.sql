--liquibase formatted sql
--changeset Nikolay Chernichko:5
CREATE TABLE user_liked_playlist
(
    user_id uuid NOT NULL,
    playlist_id uuid NOT NULL,
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT playlist_id_fk FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);

--rollback drop table user_liked_playlist;
