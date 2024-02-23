CREATE SCHEMA IF NOT EXISTS task_manager;

CREATE TABLE IF NOT EXISTS task_manager."user"
(
    id        bigserial primary key,
    firstname varchar,
    lastname  varchar,
    username  varchar   not null,
    email     varchar   not null,
    password  varchar   not null,
    role      varchar   not null,
    created   timestamp not null,
    updated   timestamp
);

CREATE TABLE IF NOT EXISTS task_manager.project
(
    id      bigserial primary key,
    name    varchar   not null,
    created timestamp not null,
    updated timestamp
);

CREATE TABLE IF NOT EXISTS task_manager.status
(
    id         bigserial primary key,
    project_id bigint    not null references task_manager.project (id),
    name       varchar   not null,
    created    timestamp not null
);

CREATE TABLE IF NOT EXISTS task_manager.task
(
    id          bigserial primary key,
    user_id     bigint references task_manager."user" (id),
    project_id  bigint    not null references task_manager.project (id),
    status_id   bigint    not null references task_manager.status (id),
    name        varchar   not null,
    description varchar,
    created     timestamp not null,
    updated     timestamp
);

CREATE TABLE users_projects
(
    user_id    bigint references task_manager."user" (id),
    project_id bigint references task_manager.project (id),
    constraint users_projects_pk primary key (user_id, project_id)
);