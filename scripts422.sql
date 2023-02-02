CREATE TABLE man (
    id serial,
    name text PRIMARY KEY,
    age integer,
    license boolean,
);
CREATE TABLE car (
    id serial PRIMARY KEY,
    brand text,
    model text,
    cost integer,
);
