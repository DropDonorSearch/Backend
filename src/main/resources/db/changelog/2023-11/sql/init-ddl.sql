CREATE SCHEMA IF NOT EXISTS donor_search;

CREATE TABLE donor_search.special_project
(
    special_project_id bigint primary key,
    image_url varchar(255) not null,
    status varchar(20) not null,
    date date not null,
    title varchar(255) not null,
    description text not null,
    created timestamp,
    updated timestamp
);

CREATE TABLE donor_search.journal (
    journal_id bigserial PRIMARY KEY,
    author varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    description text NOT NULL,
    created timestamp,
    updated timestamp
);
