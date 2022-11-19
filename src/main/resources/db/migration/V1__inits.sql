CREATE TABLE IF NOT EXISTS client(
    id SERIAL,
    nui VARCHAR (13) NOT NULL,
    fullname VARCHAR (100),
    adress VARCHAR (100),
    PRIMARY KEY (id),
    Unique(nui)
);