drop table if exists public.author;
drop table if exists public.book;

create table public.author
(
    id        serial primary key,
    firstname character varying(255) COLLATE pg_catalog."default",
    lastname  character varying(255) COLLATE pg_catalog."default"
);

create table public.book
(
    id          serial primary key,
    description text,
    isbn        character varying(255) COLLATE pg_catalog."default",
    page        integer          NOT NULL,
    price       double precision NOT NULL,
    title       character varying(100) COLLATE pg_catalog."default",
    author_id   integer          not null references public.author (id)
);