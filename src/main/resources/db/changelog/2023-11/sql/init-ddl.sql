CREATE SCHEMA IF NOT EXISTS donor_search;

CREATE TABLE special_project
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
