ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age > 16);

ALTER TABLE student
    ADD CONSTRAINT name_not_null NOT NULL (name);

ALTER TABLE student
    ADD CONSTRAINT name_unique UNIQUE (name);

ALTER TABLE faculty
    ADD CONSTRAINT name_colour_unique UNIQUE (name, colour);

ALTER TABLE student
    ALTER COLUMN age DEFAULT (age = 20);