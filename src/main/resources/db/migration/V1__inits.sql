CREATE TABLE IF NOT EXISTS asistente(
    id SERIAL,
    nombres VARCHAR (100) NOT NULL,
    email VARCHAR (100),
    institucion VARCHAR (100),
    cargo VARCHAR (100),
    PRIMARY KEY (id),
    Unique(email)
);