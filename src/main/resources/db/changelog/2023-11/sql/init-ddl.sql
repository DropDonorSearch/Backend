CREATE SCHEMA IF NOT EXISTS donor_search;

CREATE TABLE IF NOT EXISTS donor_search.special_project
(
    special_project_id BIGINT primary key,
    image_url          VARCHAR(255) not null,
    status             VARCHAR(20)  not null,
    date               DATE         not null,
    title              VARCHAR(255) not null,
    description        VARCHAR(255) not null,
    created            TIMESTAMP,
    updated            TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donor_search.journal
(
    journal_id  BIGSERIAL PRIMARY KEY,
    author      VARCHAR(255) NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donor_search.user
(
    external_id BIGINT PRIMARY KEY,
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    middle_name VARCHAR(255),
    username    VARCHAR(255),
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(255),
    gender      VARCHAR(255),
    about       VARCHAR(255),
    created     TIMESTAMP,
    updated     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donor_search.bonus
(
    bonus_id        BIGSERIAL PRIMARY KEY,
    avatar_url      VARCHAR(255),
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255),
    promo           VARCHAR(255) NOT NULL,
    expiration_date DATE,
    created_at      TIMESTAMP    NOT NULL,
    updated_at      TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donor_search.users_bonuses
(
    id       BIGSERIAL PRIMARY KEY,
    user_id  BIGINT REFERENCES donor_search."user" (external_id),
    bonus_id BIGINT REFERENCES donor_search.bonus (bonus_id),
    created  TIMESTAMP,
    updated  TIMESTAMP
);