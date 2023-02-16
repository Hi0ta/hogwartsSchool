CREATE TABLE car (
    id serial PRIMARY KEY,
    brand text,
    model text,
    cost integer
);
CREATE TABLE man (
    id serial PRIMARY KEY,
    name text,
    age integer,
    license boolean,
    cars_id serial REFERENCES car (id)
);
