--liquibase formatted sql
--changeset Nikolay Chernichko:1
CREATE TABLE track
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(100) NOT NULL,
    artist varchar(100) NOT NULL,
    CONSTRAINT track_id_pk PRIMARY KEY (id)
);

--rollback drop table track;
