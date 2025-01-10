--liquibase formatted sql
--changeset Nikolay Chernichko:3
CREATE TABLE playlist
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(50) NOT NULL,
    owner_id uuid NOT NULL,
    CONSTRAINT playlist_id_pk PRIMARY KEY (id),
    CONSTRAINT owner_id_fk FOREIGN KEY (owner_id) REFERENCES _user(id),

);

--rollback drop table playlist;
