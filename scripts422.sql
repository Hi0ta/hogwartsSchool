CREATE TABLE table_man (
    ...
    id serial,
    name text,
    age integer,
    license boolean,
    ...
);
CREATE TABLE table_car (
    ...
    id serial,
    brand text,
    model text,
    cost integer,
    ...
);
CREATE TABLE table_man (
    ...
    id serial,
    name TEXT PRIMARY KEY,
    car_id serial REFERENCES table_car (id)
    ...
);