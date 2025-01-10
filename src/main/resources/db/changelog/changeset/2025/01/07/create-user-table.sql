--liquibase formatted sql
--changeset Nikolay Chernichko:2
CREATE TABLE _user
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    role varchar(50) NOT NULL,
    CONSTRAINT user_id_pk PRIMARY KEY (id)

);

--rollback drop table _user;
