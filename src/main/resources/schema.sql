CREATE TABLE IF NOT EXISTS users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50)) NOT NULL,
    descripcio VARCHAR(1000) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    contrasenya VARCHAR(20) NOT NULL,
    ultim_acces DATETIME,
    data_creacio DATETIME,
    data_actualitzat DATETIME
    );