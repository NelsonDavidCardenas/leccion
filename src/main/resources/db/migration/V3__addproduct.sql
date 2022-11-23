CREATE TABLE IF NOT EXISTS product(
    id SERIAL,
    descripcion VARCHAR (100) NOT NULL,
    brand VARCHAR (100) NOT NULL,
    stock VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)
);