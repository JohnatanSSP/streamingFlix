CREATE TABLE movie(
    id serial PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    year_movie numeric,
    director varchar(255),
    rating numeric,
    release_date date,
    created_at timestamp,
    update_at timestamp
);