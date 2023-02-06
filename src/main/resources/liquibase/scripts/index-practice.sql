-- liquibase formatted sql

-- changeset ananova:1
CREATE INDEX student_name_index ON student (name);

-- changeset ananova:2
CREATE INDEX faculty_nc_index ON faculty (name, colour);

